/**
 * 
 */
package com.tbooking.services;

import com.tbooking.entities.Car;
import com.tbooking.entities.Coordinate;

/**
 * @author Shailendra
 *
 */
public interface ICarFinderService {

	/**
	 * Find the car for customer
	 * 
	 * @param customerCoordinates
	 * 
	 * @return car
	 */
	Car find(Coordinate customerCoordinates);
}
