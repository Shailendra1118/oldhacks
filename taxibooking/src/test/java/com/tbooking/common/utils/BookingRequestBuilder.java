/**
 * 
 */
package com.tbooking.common.utils;

import java.util.function.Consumer;

import com.tbooking.entities.Coordinate;
import com.tbooking.entities.SourceDestination;

/**
 * @author Shailendra
 *
 */
public class BookingRequestBuilder {

	private Coordinate source;
	private Coordinate destination;

	public BookingRequestBuilder with(
			Consumer<BookingRequestBuilder> builderFunction) {
		builderFunction.accept(this);
		return this;
	}

	public SourceDestination createInput() {
		return new SourceDestination(source, destination);
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(Coordinate source) {
		this.source = source;
	}

	/**
	 * @param destination
	 *            the destination to set
	 */
	public void setDestination(Coordinate destination) {
		this.destination = destination;
	}
}
