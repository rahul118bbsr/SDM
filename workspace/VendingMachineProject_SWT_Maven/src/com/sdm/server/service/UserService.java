/**
 * 
 */
package com.sdm.server.service;

import com.sdm.server.dao.IUserDao;
import com.sdm.server.dao.UserDao;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 02-Nov-2016 10:07:04 AM
 *
 */
public class UserService implements IUserService {
	private IUserDao userDao = null;
	
	public UserService() {
		userDao = new UserDao();
	}

	/* (non-Javadoc)
	 * @see com.sdm.server.service.IUserService#isValidUser(java.lang.String)
	 */
	@Override
	public boolean isValidUser(String userName) {
		return userDao.isValidUser(userName);
	}

}
