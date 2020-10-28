/**
 * 
 */
package com.tbooking.services;

import java.math.BigDecimal;

import com.tbooking.entities.Coordinate;

/**
 * @author Shailendra
 *
 */
public interface IDistanceService {

	/**
	 * Calculates distance between source and destination
	 * 
	 * @param source
	 * @param destination
	 * @return distance
	 */
	BigDecimal calculate(Coordinate source, Coordinate destination);

}
