/**
 * 
 */
package com.tbooking.entities;

/**
 * @author Shailendra
 *
 *         Input for received booking request
 */
public class SourceDestination {

	private Coordinate source;

	private Coordinate destination;

	public SourceDestination() {
		// default
	}

	public SourceDestination(Coordinate source, Coordinate destination) {
		this.source = source;
		this.destination = destination;
	}

	/**
	 * @return the source
	 */
	public Coordinate getSource() {
		return source;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(Coordinate source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public Coordinate getDestination() {
		return destination;
	}

	/**
	 * @param destination
	 *            the destination to set
	 */
	public void setDestination(Coordinate destination) {
		this.destination = destination;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("source: {" + this.source.getX() + "," + this.source.getY()
				+ "}");
		sb.append("dest: {" + this.destination.getX() + ","
				+ this.destination.getY() + "}");
		return sb.toString();
	}
}
