/**
 * 
 */
package com.tbooking.controllers;

import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tbooking.common.utils.BookingRequestBuilder;
import com.tbooking.entities.Coordinate;
import com.tbooking.entities.SourceDestination;
import com.tbooking.rest.controllers.BookingController;
import com.tbooking.services.IBookingService;

/**
 * @author Shailendra
 *
 */
public class BookingControllerRestTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Mock
	private IBookingService service;

	@InjectMocks
	private BookingController controller;

	private MockMvc mockMvc;

	private final Map<Long, String> res = new HashMap<>();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		res.put(2L, "4");
	}

	// private final BookingResponse resp = new BookingResponse();

	private final SourceDestination sd = new BookingRequestBuilder().with(
			s -> {
				s.setSource(new Coordinate(2, 4));
				s.setDestination(new Coordinate(1, 3));
			}).createInput();

	@Test
	public void getPriceDetailsSuccess() throws Exception {

		when(service.bookAndGetVehical(refEq(sd))).thenReturn(res);

		RequestBuilder requestBuilder = post("/api/book").contentType(
				MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(asJsonString(sd));

		mockMvc.perform(requestBuilder)
				.andDo(h -> logger.info("Booking Response JSON: "
						+ h.getResponse().getContentAsString()))
				.andExpect(status().isCreated())
				.andExpect(
						content().contentType(
								MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.carId", is(2)))
				.andExpect(jsonPath("$.totalTime", is("4")));

		verify(service, Mockito.times(1)).bookAndGetVehical(refEq(sd));
		verifyNoMoreInteractions(service);

	}

	/*
	 * converts a Java object into JSON representation
	 */
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
