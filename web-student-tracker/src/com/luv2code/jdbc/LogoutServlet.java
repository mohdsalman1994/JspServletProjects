package com.luv2code.jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Logout Servlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param request
	 * @param response
	 *            This method on receiving a request logs out a user by invalidating
	 *            the session
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		httpSession = request.getSession();
		System.out.println(httpSession.getAttribute("user"));
		response.sendRedirect(request.getContextPath() + "/login.jsp?message=LOGOUT");

	}

}
