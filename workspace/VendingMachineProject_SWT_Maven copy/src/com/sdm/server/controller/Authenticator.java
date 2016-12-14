/**
 *
 */
package com.sdm.server.controller;

import java.util.Objects;

import com.sdm.common.exception.IdAuthneticationException;
import com.sdm.server.service.IUserService;
import com.sdm.server.service.UserService;
import com.sdm.server.util.UserHelper;

/**
 * This class authenticates the user id that is scanned at the vending machine
 *
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 6:37:00 PM
 * @Project Assignment 5
 */
public class Authenticator implements IAuthenticator {

	/*
	 * This is an interface method to verify the user with its authentication process.
	 *
	 * @see com.sdm.server.controller.IAuthenticator#authenticateId(java.lang.String)
	 */
	@Override
	public void authenticateId(String id) throws IdAuthneticationException {
		UserHelper.getInstance().reset();
		if(Objects.isNull(id) || Objects.equals(id, "")) {
			throw new IdAuthneticationException("ID cannot be empty. Please scan your id again");
		}

		IUserService userService = new UserService();
		boolean isUserValid = userService.isValidUser(id);
		if(!isUserValid) {
			throw new IdAuthneticationException("User " + id + " is not valid. Please scan your id again");
		}
		UserHelper.getInstance().saveUserName(id);
	}
}
