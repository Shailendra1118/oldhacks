/**
 * 
 */
package com.tbooking.services.impl;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tbooking.bootstrap.App;
import com.tbooking.entities.Coordinate;
import com.tbooking.services.IDistanceService;

/**
 * @author Shailendra
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ManhattanDistanceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IDistanceService service;

	@org.junit.Test
	public void calculateTest() {
		Coordinate src = new Coordinate(1, 3);
		Coordinate dest = new Coordinate(3, 7);
		BigDecimal res = service.calculate(src, dest);
		logger.info("Manhattan distance: " + res.toString());
		assertThat(res.toString(), is("6"));

	}
}