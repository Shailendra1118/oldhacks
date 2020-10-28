/**
 * 
 */
package com.tbooking.services;

/**
 * @author Shailendra
 *
 */
public interface IVehicalResetService {

	/**
	 * reset all cars data back to the initial state regardless of cars that are
	 * currently booked.
	 */
	void resetAll();

}
