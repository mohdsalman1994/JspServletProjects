package com.aceprogrammer.sessionExamples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class First
 */
@WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName");
		out.print("Welcome " + userName);

		HttpSession session = request.getSession(true);
		session.setAttribute("uName", userName);

		// retrieving data from ServletContext object
		ServletContext servletContext = getServletContext();
		// int totalUsers = (Integer) servletContext.getAttribute("totalUsers");
		// int currentUsers = (Integer) servletContext.getAttribute("currentUsers");
		out.print("<br>total users= " + servletContext.getAttribute("totalUsers"));
		out.print("<br>current users= " + servletContext.getAttribute("currentUsers"));

		out.print("<br><a href='Logout'>logout</a>");

		out.close();
	}

}
