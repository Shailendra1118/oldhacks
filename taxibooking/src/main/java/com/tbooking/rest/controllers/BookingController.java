/**
 * 
 */
package com.tbooking.rest.controllers;

import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tbooking.entities.SourceDestination;
import com.tbooking.response.message.BookingResponse;
import com.tbooking.services.IBookingService;

/**
 * @author Shailendra
 *
 */
@RestController
public class BookingController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IBookingService bookingService;

	@RequestMapping(value = "/api/book", method = RequestMethod.POST)
	public ResponseEntity<BookingResponse> book(
			@RequestBody SourceDestination sourceDestination) {
		logger.info("book called...");
		// TODO use direct BookingResponse from booking response
		Map<Long, String> res = bookingService
				.bookAndGetVehical(sourceDestination);
		BookingResponse resp = new BookingResponse();

		Entry<Long, String> entry = res.entrySet().iterator().next();
		resp.setCarId(entry.getKey());
		resp.setTotalTime(entry.getValue());
		return new ResponseEntity<BookingResponse>(resp, HttpStatus.CREATED);

	}
}
