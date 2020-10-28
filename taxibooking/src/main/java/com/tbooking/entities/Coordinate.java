/**
 * 
 */
package com.tbooking.entities;

/**
 * @author Shailendra
 * 
 *         X and Y of 2D grid world
 */
public class Coordinate {

	private int x;

	private int y;

	public Coordinate() {
		// default constructor
	}

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return this.x + "," + this.y;
	}

	public boolean equals(Object other) {
		if (other == null)
			return false;
		Coordinate otherc = (Coordinate) other;
		if (otherc.getX() == this.getX() && otherc.getY() == this.getY())
			return true;
		else
			return false;
	}

	public int hashCode() {
		int hash = 31 * 1 + this.getX();
		hash = 31 * 1 + this.getY();
		return hash;
	}

}
