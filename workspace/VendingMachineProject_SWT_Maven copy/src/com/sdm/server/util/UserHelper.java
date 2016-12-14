/**
 * 
 */
package com.sdm.server.util;

import java.util.Objects;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 23-Nov-2016 11:26:38 AM
 *
 */
public class UserHelper {
	private String userName = null;
	private static UserHelper userHelper;
	
	private UserHelper(){}
	
	public static UserHelper getInstance() {
		if(Objects.isNull(userHelper)) {
			userHelper = new UserHelper();
		}
		return userHelper;
	}
	
	public void reset() {
		this.userName = null;
		userHelper = null;
	}
	
	public void saveUserName(String id) {
		this.userName = id;
	}
	
	public String getUserName() {
		return userName;
	}
}
