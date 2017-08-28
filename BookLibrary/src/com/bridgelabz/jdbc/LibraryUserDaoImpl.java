/**
 * 
 */
package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.bridgelabz.dao.LibraryUserDAO;

/**
 * @author Salman Shaikh
 *
 */
public class LibraryUserDaoImpl implements LibraryUserDAO {

	// can't use @Resource annotation since this is POJO class. It applies to Java
	// EE elements only.
	private DataSource dataSource;

	/**
	 * @param dataSource
	 *            used to obtain connection to the database
	 */
	public LibraryUserDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * @param email
	 * @param password
	 * @return true or false i.e. the user details are valid or not This method
	 *         checks if the user exists in the database or not
	 * @throws SQLException
	 */
	public boolean authenticate(String email, String password) throws SQLException {

		// get a connection to database
		try (Connection connection = dataSource.getConnection()) {

			// create sql to check if a record exists with a given username and password
			String sql = "select * from appusers where email=? and password=?";

			// prepare statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set the parameters
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			// store the results in resultset
			ResultSet resultSet = preparedStatement.executeQuery();

			// check if a user record exists
			if (resultSet.next()) {
				return true;
			}
		}

		return false;
	}

}
