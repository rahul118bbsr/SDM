/**
 * 
 */
package com.sdm.common.exception;

/**
 * This is an Exception class which is thrown when the user fails to identify the user id.
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 21-Oct-2016 1:12:01 PM
 *
 */
public class IdAuthneticationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public IdAuthneticationException(String message) {
		super(message);
	}


}
