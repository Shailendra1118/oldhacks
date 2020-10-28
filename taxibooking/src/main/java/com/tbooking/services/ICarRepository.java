/**
 * 
 */
package com.tbooking.services;

import java.util.Map;

import com.tbooking.entities.Car;

/**
 * @author Shailendra
 *
 */
public interface ICarRepository {

	/**
	 * Initialize all cars
	 */
	void initRepository();

	/**
	 * Add car to the repository
	 * 
	 * @param car
	 */
	void addCar(Car car);

	/**
	 * @return Set of all cars
	 */
	Map<Long, Car> findAll();

	/**
	 * @return Set of all free cars
	 */
	Map<Long, Car> findAllAvailable();

}
