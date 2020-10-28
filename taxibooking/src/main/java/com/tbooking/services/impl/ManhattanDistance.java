/**
 * 
 */
package com.tbooking.services.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.tbooking.entities.Coordinate;
import com.tbooking.services.IDistanceService;

/**
 * @author Shailendra
 *
 */
@Component
public class ManhattanDistance implements IDistanceService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tbooking.services.IDistanceService#calculate(com.tbooking.entities
	 * .Coordinate, com.tbooking.entities.Coordinate)
	 */
	@Override
	public BigDecimal calculate(Coordinate source, Coordinate destination) {
		// (a,b) (c,d) = |a-c| + |b-d|

		BigDecimal srcX = new BigDecimal(source.getX());
		BigDecimal srcY = new BigDecimal(source.getY());

		BigDecimal destX = new BigDecimal(destination.getX());
		BigDecimal destY = new BigDecimal(destination.getY());

		// calculate absolute values
		return srcX.subtract(destX).abs().add(srcY.subtract(destY).abs());

	}

}
