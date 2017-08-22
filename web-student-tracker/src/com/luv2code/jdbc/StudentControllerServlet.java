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

	@Resource(name = "jdbc/web_student_tracker")
	DataSource dataSource;

	/*
	 * In this method we initialize the necessary objects i.e. StudentDbUtil
	 */
	@Override
	public void init() throws ServletException {

		// create our student db_util ... and pass in the connection pool/datasource
		studentDbUtil = new StudentDbUtil(dataSource);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * // session variable HttpSession httpSession = request.getSession(false);
		 * System.out.println(httpSession);
		 * 
		 * if (httpSession == null) {
		 * System.out.println("Sorry you must login to access this page");
		 * response.sendRedirect(request.getContextPath() +
		 * "/login.jsp?message=INVALID"); } else { doPost(request, response); }
		 */
		doPost(request, response);
	}

	/*
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// read the command parameter
			String command = request.getParameter("command");

			// if the command is missing, then default to list students
			if (command == null) {
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
					loadStudent(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case "update":
				updateStudent(request, response);
				break;

			case "delete":
				deleteStudent(request, response);
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
	 *            This method deletes the student sent by the request from
	 *            list-students or view page of our MVC model and sends the user
	 *            back to homepage
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 */
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		// read the student id from the request
		String studentId = request.getParameter("studentId");

		// delete the student from the database
		studentDbUtil.deleteStudent(studentId);

		// send the user back to "list students" page
		listStudents(request, response);

	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 * @throws SQLException
	 *             This method updates the student sent by the request from
	 *             list-students or view page of our MVC model and sends the user
	 *             back to homepage
	 */
	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

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
	 *            This method is used for updating student details sent by request
	 *            from the view page i.e. list-students
	 * @throws Exception
	 */
	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read the student if from the form data
		String studentId = request.getParameter("studentId");

		// get student details from the database (db util)
		Student student = studentDbUtil.getStudent(studentId);

		// place student in the request attribute
		request.setAttribute("theStudent", student);

		// send to jsp page: update-student-form.jsp
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 * @throws SQLException
	 *             This method adds student to the database from the request sent by
	 *             the view page i.e. list-student
	 */
	private void addStudents(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

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
	 *             Forwards the list of students from our Model class i.e.
	 *             StudentDbUtil to view i.e. list-students.jsp
	 * 
	 */
	private void listStudents(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		// get students from studentsDbUtil
		List<Student> studentsList = studentDbUtil.getStudents();

		// add the list of students to request
		request.setAttribute("students_list", studentsList);

		// send to JSP page(view)
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list-students.jsp");
		requestDispatcher.forward(request, response);

	}

}
