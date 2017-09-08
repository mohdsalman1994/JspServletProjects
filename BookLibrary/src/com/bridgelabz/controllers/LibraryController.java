package com.bridgelabz.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.bridgelabz.dao.LibraryBookDao;
import com.bridgelabz.dao.LibraryBookDaoImpl;
import com.bridgelabz.entity.Book;
import com.bridgelabz.entity.LibraryUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class LibraryController
 */
@WebServlet("/LibraryController")
public class LibraryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Our DAO reference
	LibraryBookDao libraryBookUtil;

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
		libraryBookUtil = new LibraryBookDaoImpl(dataSource);

	}

	/**
	 * All GET requests are forwarded to post
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			// read the command parameter
			String command = request.getParameter("command");

			// if the command is missing, then default to list students
			if (command == null) {
				command = "welcome";
			}

			// route to the appropiate method
			switch (command) {

			case "welcome":
				displayHomePage(request, response);
				break;

			case "list":
				listBooks(request, response);
				break;

			case "add":
				addBook(request, response);
				break;

			case "load":
				try {
					loadBook(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case "update":
				updateBook(request, response);
				break;

			case "delete":
				deleteBook(request, response);
				break;

			default:
				displayHomePage(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param request
	 * @param response
	 */
	private void deleteBook(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param request
	 * @param response
	 */
	private void updateBook(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param request
	 * @param response
	 */
	private void loadBook(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param request
	 * @param response
	 */
	private void addBook(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 */
	private void listBooks(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		Gson gson = null;
		String category = request.getParameter("category").toLowerCase();
		HttpSession httpSession = request.getSession();

		Integer userId = null;

		if (httpSession != null) {
			LibraryUser user = (LibraryUser) httpSession.getAttribute("user");
			userId = user.getUserId();
			List<Book> bookList = libraryBookUtil.getBooks(userId, category);
			gson = new GsonBuilder().disableHtmlEscaping().create();
			JsonElement element = gson.toJsonTree(bookList, new TypeToken<List<Book>>() {
			}.getType());
			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
		}

	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void displayHomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("homepage.jsp");
		requestDispatcher.forward(request, response);

	}

}
