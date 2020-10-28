/**
 * 
 */
package com.tbooking.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tbooking.entities.Car;
import com.tbooking.entities.Coordinate;
import com.tbooking.services.ICarRepository;

/**
 * @author Shailendra
 *
 */
@Component
public class CarRepository implements ICarRepository {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private HashMap<Long, Car> cars = new HashMap<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tbooking.services.ICarRepository#findAll()
	 */
	@Override
	public Map<Long, Car> findAll() {
		return cars;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tbooking.services.ICarRepository#addCar(com.tbooking.entities.Car)
	 */
	@Override
	public void addCar(Car car) {
		this.cars.put(car.getId(), car);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tbooking.services.ICarRepository#initRepository()
	 */
	@Override
	public void initRepository() {
		for (Entry<Long, Car> ce : this.cars.entrySet()) {
			Car car = ce.getValue();
			car.setLocation(new Coordinate(0, 0));
			car.setAssignedCustomer(null);
			car.setBooked(false);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tbooking.services.ICarRepository#findAllAvailable()
	 */
	@Override
	public Map<Long, Car> findAllAvailable() {
		Map<Long, Car> availables = this.cars.entrySet().stream().filter(e -> {
			if (e.getValue().isBooked()) {
				return false;
			} else
				return true;
		}).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		logger.info("Available cars: " + availables.size());
		return availables;
	}
}
