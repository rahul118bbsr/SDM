/**
 * 
 */
package com.sdm.controller;

import java.util.Objects;

import com.sdm.exception.IdAuthneticationException;

/**
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 6:37:00 PM
 * @Project Assignment 5
 */
public class Authenticator implements IAuthenticator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sdm.controller.IAuthenticator#authenticateId(java.lang.String)
	 */
	@Override
	public void authenticateId(String id) throws IdAuthneticationException {
		if(Objects.isNull(id) || Objects.equals(id, "")) {
			throw new IdAuthneticationException("Invalid ID. Please scan your id again");
		}
		System.out.println("Authentication successful for the id: " + id);
	}

}
