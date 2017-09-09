package com.bridgelabz.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param request
	 * @param response
	 *            This method on receiving a request logs out a user by invalidating
	 *            the session
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// retrieve the session if it exists
		HttpSession httpSession = request.getSession(false);

		// invalidate the user session
		if (httpSession != null) {
			httpSession.invalidate();
			// System.out.println(httpSession.getAttribute("user"));
			response.sendRedirect(request.getContextPath() + "/login.jsp?message=LOGOUT");
		}
	}
}
