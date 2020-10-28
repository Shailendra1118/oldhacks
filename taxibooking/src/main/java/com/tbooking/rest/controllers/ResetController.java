package com.tbooking.rest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tbooking.response.message.ResponseMessage;
import com.tbooking.services.IVehicalResetService;

@RestController
public class ResetController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IVehicalResetService resetService;

	@RequestMapping(value = "/api/reset", method = RequestMethod.POST)
	public ResponseEntity<ResponseMessage> reset() {
		logger.info("reset called...");
		resetService.resetAll();
		ResponseMessage msg = new ResponseMessage();
		msg.setMessage("Rest was successful");
		return new ResponseEntity<ResponseMessage>(msg, HttpStatus.CREATED);

	}
}
