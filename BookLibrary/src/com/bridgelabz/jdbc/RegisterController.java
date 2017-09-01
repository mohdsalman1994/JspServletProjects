package com.bridgelabz.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.bridgelabz.dao.LibraryUserDaoImpl;

/**
 * This controller handles user registration
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Our DAO reference
	LibraryUserDaoImpl libraryUserDbUtil;

	// database resource using annotation
	@Resource(name = "jdbc/book_library")
	DataSource dataSource;

	/*
	 * We initialize the necessary objects i.e. UserDbUtil when the servlet is
	 * initialized by the container
	 */
	@Override
	public void init() throws ServletException {

		// create our student db_util ... and pass in the connection pool/datasource
		libraryUserDbUtil = new LibraryUserDaoImpl(dataSource);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get all the fields from the registration page
		String fullName = request.getParameter("fullname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String gender = request.getParameter("gender");

		System.out.println("LibraryUser [fullName=" + fullName + ", email=" + email + ", mobile=" + mobile + ", gender="
				+ gender + ", password=" + password + ", confirmPassword=" + confirmPassword + "]");

		// pass them to the register method to handle registration
		String error = libraryUserDbUtil.register(fullName, email, mobile, password, confirmPassword, gender);

		// if no errors are found then forward to homepage
		if (error != null || error == "") {
			// proper redirect to be added
			System.out.println("No errors! Yaay");
		} else {

			// redirect to login page with error string
			System.out.println("Following errors were found: " + error);
		}

	}

}
