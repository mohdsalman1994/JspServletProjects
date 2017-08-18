package com.luv2code.jdbc;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthenticateController
 */
@WebServlet("/AuthenticateController")
public class AuthenticateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher requestDispatcher;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (Objects.equals(email, "admin@gmail.com") && Objects.equals(password, "admin")) {
			System.out.println("Inside if");
			requestDispatcher = request.getRequestDispatcher("/StudentControllerServlet");
			requestDispatcher.forward(request, response);
		} else {
			System.out.println("Inside else");
			String validUser = "invalid";
			request.setAttribute("authentic", validUser);
			System.out.println(request.getAttribute("authentic"));
			// requestDispatcher = request.getRequestDispatcher("/login.jsp");
			// requestDispatcher.forward(request, response);
			response.sendRedirect("login.jsp?authentic=" + validUser);
		}
	}

}
