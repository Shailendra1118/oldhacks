/**
 * 
 */
package com.tbooking.services.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tbooking.entities.Car;
import com.tbooking.entities.SourceDestination;
import com.tbooking.services.IBookingService;
import com.tbooking.services.ICarFinderService;
import com.tbooking.services.IDistanceService;

/**
 * @author Shailendra
 *
 */
@Component
public class BookingService implements IBookingService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICarFinderService carFinderService;

	@Autowired
	private IDistanceService distanceService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tbooking.services.IBookingService#bookAndGetVehical(com.tbooking.
	 * entities.SourceDestination)
	 */
	@Override
	public Map<Long, String> bookAndGetVehical(
			SourceDestination sourceDestination) {
		Map<Long, String> resp = new HashMap<>();
		// find the nearest available car from customer location
		Car availableCar = carFinderService.find(sourceDestination.getSource());

		if (availableCar != null) {
			// calculate the total time = time to reach to customer +
			// destination
			BigDecimal toReachCust = distanceService.calculate(
					availableCar.getLocation(), sourceDestination.getSource());

			BigDecimal toReachDest = distanceService.calculate(
					sourceDestination.getSource(),
					sourceDestination.getDestination());

			BigDecimal totalTime = toReachCust.add(toReachDest);
			// resp.setTotalTime(totalTime);
			resp.put(availableCar.getId(), totalTime.toString());

			// book the car
			logger.info("booked car:" + availableCar.getId() + ", Time: "
					+ totalTime);
		}

		return resp;
	}

}
