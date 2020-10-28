/**
 * 
 */
package com.tbooking.response.message;


/**
 * @author Shailendra
 *
 *         Represent Booking Response on reques
 */
public class BookingResponse {

	private long carId;

	private String totalTime;

	public BookingResponse() {

	}

	/**
	 * @return the totalTime
	 */
	public String getTotalTime() {
		return totalTime;
	}

	/**
	 * @param totalTime
	 *            the totalTime to set
	 */
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}
}
