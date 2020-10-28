/**
 * 
 */
package com.tbooking.services.impl;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashMap;

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
import com.tbooking.services.ICarFinderService;
import com.tbooking.services.ICarRepository;

/**
 * @author Shailendra
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class NearestCarFinderServiceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@InjectMocks
	private ICarFinderService service;

	@Mock
	private ICarRepository repo;

	private Coordinate customerLoc;
	private HashMap<Long, Car> cars = new HashMap<>();

	@Before
	public void setUp() {
		customerLoc = new Coordinate(2, 1);
		Car c2 = new Car(2L);
		c2.setLocation(new Coordinate(1, 3));
		Car c1 = new Car(1L);
		c1.setLocation(new Coordinate(5, 2));
		Car c3 = new Car(3L);
		c3.setLocation(new Coordinate(5, 0));

		cars.put(c2.getId(), c2);
		cars.put(c1.getId(), c1);
		cars.put(c3.getId(), c3);

	}

	@Test
	public void findTest() {
		Mockito.when(repo.findAllAvailable()).thenReturn(cars);
		Car car = service.find(customerLoc);
		logger.info(car.getId().toString());
		logger.info(car.getLocation().toString());

		assertThat(car.getId(), is(2L));

		// test for car location
		assertEquals(car.getLocation(), new Coordinate(1, 3));

		// test for booking status
		assertEquals(car.isBooked(), true);
		verify(repo, times(1)).findAllAvailable();

	}

}
