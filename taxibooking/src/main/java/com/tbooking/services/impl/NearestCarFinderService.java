/**
 * 
 */
package com.tbooking.services.impl;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tbooking.entities.Car;
import com.tbooking.entities.Coordinate;
import com.tbooking.services.ICarFinderService;
import com.tbooking.services.ICarRepository;
import com.tbooking.services.IDistanceService;

/**
 * @author Shailendra
 *
 */
@Component
public class NearestCarFinderService implements ICarFinderService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IDistanceService distanceService;

	@Autowired
	private ICarRepository carRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tbooking.services.ICarFinderService#find(com.tbooking.entities.Coordinate
	 * )
	 */
	@Override
	public Car find(Coordinate customerCoordinates) {
		Car bestCar = null;
		Map<Long, Car> allCars = carRepository.findAllAvailable();
		// TODO if more than one car is on the same location at use only with
		// lower car id
		for (Entry<Long, Car> car : allCars.entrySet()) {
			logger.info(car.getKey() + ": " + car.getValue().getLocation());
		}

		Map<Long, Car> sorted = allCars
				.entrySet()
				.stream()
				.sorted((e1, e2) -> {
					BigDecimal cToa = distanceService.calculate(
							customerCoordinates, e1.getValue().getLocation());

					BigDecimal cTob = distanceService.calculate(
							customerCoordinates, e2.getValue().getLocation());

					logger.info("ctoa: " + cToa + " ctob: " + cTob);

					if (cToa.equals(cTob)) {
						return (int) Math.min(e1.getValue().getId(), e2
								.getValue().getId());
					} else {
						return cToa.compareTo(cTob);
					}

				})
				.collect(
						Collectors.toMap(Map.Entry::getKey,
								Map.Entry::getValue, (e1, e2) -> e1,
								LinkedHashMap::new));

		for (Entry<Long, Car> car : sorted.entrySet()) {
			logger.info(car.getKey() + ": " + car.getValue().getLocation());
		}

		if (!sorted.isEmpty()) {
			bestCar = sorted.entrySet().iterator().next().getValue();
			// re-check for booking
			if (!bestCar.isBooked()) {
				bestCar.setBooked(true);
			} else
				return null;
		}

		return bestCar;

	}
}
