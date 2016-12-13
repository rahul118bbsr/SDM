/**
 * 
 */
package com.sdm.common.exception;

/**
 * This is an Exception class which is thrown when the user fails to pay.
 * 
 * @author Rahul Dev Mishra
 * @assignment Assignment 7
 * @date 21-Oct-2016 1:12:01 PM
 *
 */
public class InvalidPaymentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public InvalidPaymentException(String message) {
		super(message);
	}


}
