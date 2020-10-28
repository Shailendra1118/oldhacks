/**
 * 
 */
package com.tbooking.services.impl;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tbooking.bootstrap.App;
import com.tbooking.entities.Car;
import com.tbooking.entities.Coordinate;
import com.tbooking.entities.SourceDestination;
import com.tbooking.services.IBookingService;
import com.tbooking.services.ICarFinderService;

/**
 * @author Shailendra
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class BookingServiceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Mock
	private ICarFinderService carFinderService;

	@Autowired
	@InjectMocks
	private IBookingService service;

	private SourceDestination sourceDestination = null;
	private Car availableCar = null;

	@Before
	public void setUp() {

	}

	@Test
	public void testCarsInitialLocation() {
		Car c1 = new Car(1L);
		assertThat(c1.getLocation(), is(new Coordinate(0, 0)));
		Car c2 = new Car(2L);
		assertThat(c2.getLocation(), is(new Coordinate(0, 0)));
		Car c3 = new Car(3L);
		assertThat(c3.getLocation(), is(new Coordinate(0, 0)));
	}

	@Test
	public void findTest() {
		sourceDestination = new SourceDestination();
		Coordinate source = new Coordinate(2, 1);
		Coordinate dest = new Coordinate(3, 4);
		sourceDestination.setSource(source);
		sourceDestination.setDestination(dest);
		availableCar = new Car(2L);

		Mockito.when(carFinderService.find(sourceDestination.getSource()))
				.thenReturn(this.availableCar);
		Map<Long, String> resp = service.bookAndGetVehical(sourceDestination);
		Entry<Long, String> entry = resp.entrySet().iterator().next();
		logger.info("Car: " + entry.getKey());
		logger.info("Time: " + entry.getValue());
		assertThat(entry.getKey(), is(2L));
		assertThat(entry.getValue(), is("7"));

	}

	@Test
	public void big2DWorldTest() {
		sourceDestination = new SourceDestination();
		Coordinate source = new Coordinate(2147483647, 0);
		Coordinate dest = new Coordinate(0, 2147483647);
		sourceDestination.setSource(source);
		sourceDestination.setDestination(dest);
		availableCar = new Car(1L); // default location 0,0

		Mockito.when(carFinderService.find(sourceDestination.getSource()))
				.thenReturn(this.availableCar);

		Map<Long, String> resp = service.bookAndGetVehical(sourceDestination);
		Entry<Long, String> entry = resp.entrySet().iterator().next();
		logger.info("Car: " + entry.getKey());
		logger.info("Time: " + entry.getValue());

		assertThat(entry.getKey(), is(1L));
		assertThat(entry.getValue(), is("6442450941"));

	}

}
