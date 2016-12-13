/**
 * 
 */
package com.sdm.server.dao;

import java.util.Objects;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.model.Filters;
import com.sdm.server.util.DaoHelper;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 02-Nov-2016 9:49:02 AM
 *
 */
public class UserDao implements IUserDao {
	
	/* (non-Javadoc)
	 * @see com.sdm.server.dao.IUserDao#isValidUser(java.lang.String)
	 */
	@Override
	public boolean isValidUser(String userName) {
		Bson filter = Filters.eq("user", userName.toUpperCase());
		Document userDocument = DaoHelper.fetchUserCollection().find(filter).first();
		return Objects.nonNull(userDocument);
	}
	
}
