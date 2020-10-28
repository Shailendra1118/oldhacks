/**
 * 
 */
package com.tbooking.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Shailendra
 *
 */
public class TestUtils {

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
