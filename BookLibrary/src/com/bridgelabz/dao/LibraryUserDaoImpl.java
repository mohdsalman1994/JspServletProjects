/**
 * 
 */
package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.sql.DataSource;

/**
 * @author Salman Shaikh
 *
 */
/**
 * @author Salman Shaikh
 *
 */
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

	public String register(String fullName, String email, String mobile, String password, String confirmPassword,
			String gender) {
		String error = "";
		Pattern pattern = null;
		String digits = "\\d";
		String fullnameRegex = "[a-zA-Z]+ [a-zA-Z]+( [a-zA-Z])*";
		String emailRegex = "([a-zA-Z0-9_.+-])+\\@(([a-zA-Z0-9-])+\\.)+([a-zA-Z0-9]{2,4})+$";
		String mobileRegex = "[0-9]{10}";

		// first check for null data or empty data and error messages accordingly
		if (isNullOrBlank(fullName)) {
			error += "<p>Fullname required!</p>";

		} else {

			// check if fullname contains any numbers

			// check if fullname contains only two words

		}

		if (isNullOrBlank(email)) {
			error += "<p>Email required!</p>";
		} else {

		}

		if (isNullOrBlank(mobile)) {
			error += "<p>Mobile no required!</p>";
		} else {

		}

		if (isNullOrBlank(password)) {
			error += "<p>Password required!</p>";
		} else {

		}

		if (isNullOrBlank(confirmPassword)) {
			error += "<p>Confirm Password required!</p>";
		} else {

		}

		if (isNullOrBlank(gender)) {
			error += "<p>Gender required!</p>";
		} else {

		}

		return error;
	}

	/**
	 * @return whether the given username is already present or not
	 */
	public boolean checkUsername() {
		return false;
	}

	public boolean isNullOrBlank(String s) {

		return (s == null || s.trim().equals(""));
	}

}
