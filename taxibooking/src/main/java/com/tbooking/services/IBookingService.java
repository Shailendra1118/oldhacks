/**
 * 
 */
package com.tbooking.services;

import java.util.Map;

import com.tbooking.entities.SourceDestination;

/**
 * @author Shailendra
 *
 */
public interface IBookingService {

	/**
	 * book the car and return carId and total time
	 * 
	 * @param sourceDestination
	 */
	Map<Long, String> bookAndGetVehical(SourceDestination sourceDestination);

}
