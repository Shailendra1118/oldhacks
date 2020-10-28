/**
 * 
 */
package com.tbooking.rest.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tbooking.response.message.ResponseMessage;

/**
 * @author Shailendra
 *
 */

@RestController
public class TickController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private AtomicLong timeUnit = new AtomicLong(100L);

	@RequestMapping(value = "/api/tick", method = RequestMethod.POST)
	public ResponseEntity<ResponseMessage> tick() {
		logger.info("tick called...");

		timeUnit.incrementAndGet();
		ResponseMessage msg = new ResponseMessage();
		msg.setMessage("Rest was successful");
		msg.setData(String.valueOf(Long.valueOf(timeUnit.get())));
		logger.info("TimeUnit" + msg.getData());
		return new ResponseEntity<ResponseMessage>(msg, HttpStatus.CREATED);

	}
}