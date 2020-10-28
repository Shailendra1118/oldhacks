/**
 * 
 */
package com.tbooking.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.tbooking.entities.Car;
import com.tbooking.entities.Coordinate;
import com.tbooking.services.ICarRepository;

/**
 * @author Shailendra
 * 
 *         On startup, initialize the Car repository that currenty have only 3
 *         Cars
 */
@Component
public class AppStartup implements ApplicationListener<ApplicationReadyEvent> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICarRepository carRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationListener#onApplicationEvent(org
	 * .springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Car c2 = new Car(2L);
		c2.setLocation(new Coordinate(1, 3));
		Car c1 = new Car(1L);
		c1.setLocation(new Coordinate(5, 2));
		Car c3 = new Car(3L);
		c3.setLocation(new Coordinate(5, 0));
		carRepo.addCar(c2);
		carRepo.addCar(c3);
		carRepo.addCar(c1);

		logger.info("Car repository is initialized with number of cars");

	}
}
