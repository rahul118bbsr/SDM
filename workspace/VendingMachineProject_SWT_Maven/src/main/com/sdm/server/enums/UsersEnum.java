/**
 * 
 */
package main.com.sdm.server.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 20-Nov-2016 11:59:44 AM
 *
 */
public enum UsersEnum {
	USERS(Arrays.asList("RAHUL", "ALEESHA", "BOB", "SEAN", "LIZ"));
	
	private List<String> usersList = new ArrayList<>();
	private UsersEnum(List<String> usersList) {
		this.usersList = usersList;
	}
	
	public List<String> getUsersList() {
		return usersList;
	}

}
