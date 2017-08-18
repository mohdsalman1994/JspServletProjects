package com.luv2code.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudentDbUtil studentDbUtil;

	@Resource(name = "jdbc/web_student_tracker")
	DataSource dataSource;

	/*
	 * In this method we initialize the necessary objects i.e. StudentDbUtil
	 */
	@Override
	public void init() throws ServletException {

		// create our student db_util ... and pass in the connection pool/datasource
		studentDbUtil = new StudentDbUtil(dataSource);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the email and password from the login page
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// authenticate the credentials
		boolean result = false;
		try {
			result = studentDbUtil.authenticate(email, password);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// if correct credentials then forward to StudentController else back to login
		// page
		if (result) {
			response.sendRedirect(request.getContextPath() + "/StudentControllerServlet?command=LIST");
		} else {
			response.sendRedirect(request.getContextPath() + "/login.jsp?message=INVALID");
		}

	}

}
