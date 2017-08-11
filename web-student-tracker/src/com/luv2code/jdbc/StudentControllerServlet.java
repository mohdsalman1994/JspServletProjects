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

	

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/* 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			// read the command parameter
			String command = request.getParameter("command");

			// if the command is missing, then default to list students
			if(command == null) {
				command = "list";
			}

			// route to the appropiate method
			switch (command) {

			case "list":
				// list students in MVC fashion
				listStudents(request, response);
				break;

			case "add":				
				addStudents(request, response);
				break;
				
			case "load":
				try {
					loadStudent(request,response);
				} catch (Exception e) {					
					e.printStackTrace();
				}
				break;
				
			case "update":
				updateStudent(request, response);
				break;

			default:
				listStudents(request, response);
				break;
			}


		} catch (SQLException e) {			
			e.printStackTrace();
		}

	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws SQLException 
	 */
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		// read student information from the form data
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		// create student from the data
		Student student = new Student(studentId, firstName, lastName, email);
		
		// perform update on the database
		studentDbUtil.updateStudent(student);
		
		// send the user back to the list-students page
		listStudents(request, response);
		
	}

	/**
	 * @param request
	 * @param response
	 * This method is used for updating student details
	 * @throws Exception 
	 */
	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		// read the student if from the form data
		String studentId = request.getParameter("studentId");
		
		// get student details from the database (db util)
		Student student = studentDbUtil.getStudent(studentId);
				
		// place student in the request attribute
		request.setAttribute("theStudent", student);
		
		// send to jsp page: upadate-student-form.jsp
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws SQLException 
	 */
	private void addStudents(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

		// read student info from the form data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		// create a new student object
		Student student = new Student(firstName, lastName, email);

		// add the student to the database
		studentDbUtil.addStudent(student);

		// send back to main page (the student list)
        // SEND AS REDIRECT to avoid multiple-browser reload issue
        response.sendRedirect(request.getContextPath() + "/StudentControllerServlet?command=LIST");

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
