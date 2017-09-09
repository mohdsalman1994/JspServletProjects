package com.bridgelabz.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.bridgelabz.dao.LibraryBookDao;
import com.bridgelabz.dao.LibraryBookDaoImpl;
import com.bridgelabz.entity.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Define datasource/connection pool for ResourceInjection
	@Resource(name = "jdbc/book_library")
	private DataSource dataSource;

	LibraryBookDao libraryBookUtil;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		libraryBookUtil = new LibraryBookDaoImpl(dataSource);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Inside doGet");
		System.out.println("Request parameter" + request.getParameter("id"));

		/*
		 * // Step 1: Set up the printWriter PrintWriter out = response.getWriter();
		 * response.setContentType("text/html");
		 * 
		 * // Step 2: Get a connection to database try (Connection connection =
		 * dataSource.getConnection()) {
		 * 
		 * // Step 3: Create SQL statements String sql = "select * from appusers";
		 * Statement statement = connection.createStatement();
		 * 
		 * // Step 4: Execute SQL Queries ResultSet resultSet =
		 * statement.executeQuery(sql);
		 * 
		 * // Step 5: Process the result sets while (resultSet.next()) { String email =
		 * resultSet.getString("email"); out.println(email + "<br/>");
		 * 
		 * }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
		try {
			List<Book> bookList = libraryBookUtil.getBooks(7, "Arts");
			Gson gson = null;
			gson = new GsonBuilder().disableHtmlEscaping().create();
			JsonElement element = gson.toJsonTree(bookList, new TypeToken<List<Book>>() {
			}.getType());
			JsonArray jsonArray = element.getAsJsonArray();
			System.out.println(jsonArray);
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
