/**
 * 
 */
package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * @author Salman Shaikh
 *
 */
public class StudentDbUtil {

	// can't use @Resource annotation since this is POJO class. It applies to Java
	// EE elements only.
	private DataSource dataSource;

	/**
	 * @param dataSource
	 *            used to obtain connection to the database
	 */
	public StudentDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	/**
	 * @return list of students from the students table in the database
	 * @throws SQLException
	 */
	public List<Student> getStudents() throws SQLException {

		List<Student> studentsList = new ArrayList<>();

		// get a connection
		try (Connection connection = dataSource.getConnection()) {

			// create sql statement
			String sql = "select * from student order by last_name";
			Statement statement = connection.createStatement();

			// execute the query
			ResultSet resultSet = statement.executeQuery(sql);

			// process the result set
			while (resultSet.next()) {

				// retrieve a data from the result set row
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");

				// create new student
				Student student = new Student(id, firstName, lastName, email);

				// add it to the list of students
				studentsList.add(student);

			}

			// return the list of students
			return studentsList;
		}
	}

	/**
	 * @param student
	 *            This method adds student to the database
	 * @throws SQLException
	 */
	public void addStudent(Student student) throws SQLException {

		try (Connection connection = dataSource.getConnection()) {

			// create sql query for insert
			String sql = "insert into student (first_name, last_name, email) values (?, ?, ?)";

			// set parameter values for insert
			String firstName = student.getFirstName();
			String lastName = student.getLastName();
			String email = student.getEmail();

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, email);

			// execute the query
			preparedStatement.execute();

		}

	}

	/**
	 * @param studentId
	 * @return Student
	 * @throws Exception
	 *             This method returns a Student from the database whose id =
	 *             studentId.
	 */
	public Student getStudent(String studentId) throws Exception {

		Student student;

		try (Connection connection = dataSource.getConnection()) {
			// convert id from String to int
			int id = Integer.parseInt(studentId);

			// create prepared statement to retrieve the student
			String getStudentById = "select * from student where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(getStudentById);
			preparedStatement.setInt(1, id);

			// execute the statement
			ResultSet resultSet = preparedStatement.executeQuery();

			// retrieve the student from the resultSet Row
			if (resultSet.next()) {
				String firstName = resultSet.getString("first_Name");
				String lastName = resultSet.getString("last_Name");
				String email = resultSet.getString("email");

				// use the student id during student object construction
				student = new Student(id, firstName, lastName, email);
			} else {
				throw new Exception("Cannot find student with id:" + studentId);
			}

		}

		return student;
	}

	/**
	 * @param Student
	 * @throws SQLException
	 *             Updates the given Student object in the database
	 */
	public void updateStudent(Student student) throws SQLException {

		// get a connection from the database
		try (Connection connection = dataSource.getConnection()) {

			// create sql statement
			String sql = "update student set first_name=?, last_Name=?, email=?" + "where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// get the student details from the Student object
			int studentId = student.getId();
			String firstName = student.getFirstName();
			String lastName = student.getLastName();
			String email = student.getEmail();

			// set the parameters of the preparedStatement
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, email);
			preparedStatement.setInt(4, studentId);

			// execute the query
			preparedStatement.execute();

		}

	}

	/**
	 * @param studentId
	 * @throws SQLException
	 *             This method deletes the Student from the database whose id =
	 *             studentId
	 */
	public void deleteStudent(String studentId) throws SQLException {

		// get connection to database
		try (Connection connection = dataSource.getConnection()) {

			// convert student id to int
			int aStudentId = Integer.parseInt(studentId);

			// create sql to delete student
			String sql = "delete from student where id=?";

			// prepare statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameters
			preparedStatement.setInt(1, aStudentId);

			// execute sql statements
			preparedStatement.execute();
		}

	}

	/**
	 * @param email
	 * @param password
	 * @return true or false i.e. the user details are valid or not This method
	 *         checks if the user exists in the database or not
	 * @throws SQLException
	 */
	public boolean authenticate(String email, String password) throws SQLException {

		// get a connection to database
		try (Connection connection = dataSource.getConnection()) {

			// create sql to check if a record exists with a given username and password
			String sql = "select * from appusers where email=? and password=?";

			// prepare statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set the parameters
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			// store the results in resultset
			ResultSet resultSet = preparedStatement.executeQuery();

			// check if a user record exists
			if (resultSet.next()) {
				return true;
			}
		}

		return false;
	}

}
