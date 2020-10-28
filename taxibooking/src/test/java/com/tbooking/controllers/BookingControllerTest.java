package com.tbooking.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.tbooking.common.utils.BookingRequestBuilder;
import com.tbooking.entities.Coordinate;
import com.tbooking.entities.SourceDestination;
import com.tbooking.response.message.BookingResponse;

/**
 * @author Shailendra
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.tbooking.bootstrap.App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookingControllerTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	private final SourceDestination sd = new BookingRequestBuilder().with(
			s -> {
				s.setSource(new Coordinate(2, 4));
				s.setDestination(new Coordinate(1, 3));
			}).createInput();

	@Test
	public void saveAndRetrieveProduct() throws JSONException {

		HttpEntity<SourceDestination> entity = new HttpEntity<SourceDestination>(
				sd, headers);
		ResponseEntity<BookingResponse> response = restTemplate.exchange(
				createURLWithPort("/api/book"), HttpMethod.POST, entity,
				BookingResponse.class);

		BookingResponse bookingResponse = response.getBody();
		final Long carId = bookingResponse.getCarId();
		logger.info("CAR " + carId);
		assertEquals(2l, bookingResponse.getCarId());
		assertThat(HttpStatus.CREATED, is(response.getStatusCode()));

	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}