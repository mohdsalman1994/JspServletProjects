package com.bridgelabz.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Define datasource/connection pool for ResourceInjection
	@Resource(name = "jdbc/book_library")
	private DataSource dataSource;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Step 1: Set up the printWriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		// Step 2: Get a connection to database
		try (Connection connection = dataSource.getConnection()) {

			// Step 3: Create SQL statements
			String sql = "select * from appusers";
			Statement statement = connection.createStatement();

			// Step 4: Execute SQL Queries
			ResultSet resultSet = statement.executeQuery(sql);

			// Step 5: Process the result sets
			while (resultSet.next()) {
				String email = resultSet.getString("email");
				out.println(email + "<br/>");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
