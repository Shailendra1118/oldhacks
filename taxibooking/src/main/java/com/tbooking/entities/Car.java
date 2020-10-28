/**
 * 
 */
package com.tbooking.entities;

/**
 * @author Shailendra
 */

// TODO Create abstract level Vehical class and let this class extend it
public class Car {

	private Long id;

	private boolean isBooked;

	private Customer assignedCustomer;

	private Coordinate location;

	public Car() {
		// empty
	}

	public Car(Long id) {
		this.id = id;
		this.location = new Coordinate(0, 0);
		this.isBooked = false;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the assignedCustomer
	 */
	public Customer getAssignedCustomer() {
		return assignedCustomer;
	}

	/**
	 * @param assignedCustomer
	 *            the assignedCustomer to set
	 */
	public void setAssignedCustomer(Customer assignedCustomer) {
		this.assignedCustomer = assignedCustomer;
	}

	/**
	 * @return the location
	 */
	public Coordinate getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(Coordinate location) {
		this.location = location;
	}

	/**
	 * @return the isBooked
	 */
	public boolean isBooked() {
		return isBooked;
	}

	/**
	 * @param isBooked
	 *            the isBooked to set
	 */
	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (other == null)
			return false;
		if (other.getClass() == this.getClass()) {
			Car otherCar = (Car) other;
			if (this.getId().equals(otherCar.getId())
					&& this.getLocation().equals(otherCar.getLocation()))
				return true;
			else
				return false;
		}

		return false;
	}

	public int hashCode() {
		int result = 17;
		return 31 * result + this.getId().hashCode();
	}

}
