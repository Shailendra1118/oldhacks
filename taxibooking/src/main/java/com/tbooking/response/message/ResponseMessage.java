/**
 * 
 */
package com.tbooking.response.message;

/**
 * @author Shailendra
 * 
 *         Generic response message
 *
 */
public class ResponseMessage {

	private String message;
	private String data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseMessage() {

	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

}
