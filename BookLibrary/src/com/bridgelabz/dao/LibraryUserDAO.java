/**
 * 
 */
package com.bridgelabz.dao;

import java.sql.SQLException;

/**
 * @author Salman Shaikh This is our DAO interface for Library Users
 *
 */
public interface LibraryUserDAO {

	/**
	 * @param email
	 * @param password
	 * @return true or false
	 * @throws SQLException
	 *             This method tells us whether the user with given email and
	 *             password is a valid user or not.
	 */
	public boolean authenticate(String email, String password) throws SQLException;
}
