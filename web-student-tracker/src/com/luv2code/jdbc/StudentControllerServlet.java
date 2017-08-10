package com.luv2code.jdbc;

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
import javax.sql.DataSource;

/**
 * This class is our Controller in MVC
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudentDbUtil studentDbUtil;

	@Resource(name="jdbc/web_student_tracker")
	DataSource dataSource;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// list students in MVC fashion
		try {
			listStudents(request, response);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ServletException
	 * Forwards the list of students from our Model class i.e. StudentDbUtil
	 * to view i.e. list-students.jsp
	 *  
	 */
	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		// get students from studentsDbUtil
		List<Student> studentsList = studentDbUtil.getStudents();
		
		// add the list of students to request
		request.setAttribute("students_list", studentsList);
			
		// send to JSP page(view)
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list-students.jsp");
		requestDispatcher.forward(request, response);
		
		
	}

	/* 
	 * In this method we initialize the necessary objects
	 * i.e. StudentDbUtil
	 */
	@Override
	public void init() throws ServletException {

		// create our student db_util ... and pass in the connection pool/datasource
		studentDbUtil = new StudentDbUtil(dataSource);

	}



}
