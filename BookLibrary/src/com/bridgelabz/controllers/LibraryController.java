package com.bridgelabz.controllers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.bridgelabz.dao.LibraryUserDaoImpl;

/**
 * Servlet implementation class LibraryController
 */
@WebServlet("/LibraryController")
public class LibraryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Our DAO reference
	LibraryUserDaoImpl userDbUtil;

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
		userDbUtil = new LibraryUserDaoImpl(dataSource);

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
				command = "display";
			}

			// route to the appropiate method
			switch (command) {

			case "display":
				displayHomePage(request, response);
				break;

			/*
			 * case "list": listBooks(request, response); break;
			 * 
			 * case "add": addBook(request, response); break;
			 * 
			 * case "load": try { loadBook(request, response); } catch (Exception e) {
			 * e.printStackTrace(); } break;
			 * 
			 * case "update": updateBook(request, response); break;
			 * 
			 * case "delete": deleteBook(request, response); break;
			 */
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
	 * @throws IOException
	 * @throws ServletException
	 */
	private void displayHomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("homepage.jsp");
		requestDispatcher.forward(request, response);

	}

}
