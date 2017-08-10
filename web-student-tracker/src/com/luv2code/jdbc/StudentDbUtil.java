/**
 * 
 */
package com.luv2code.jdbc;

import java.sql.Connection;
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

	// can't use @Resource annotation since this is POJO class. It applies to Java EE elements only.
	private DataSource dataSource;

	public StudentDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	/**
	 * @return list of students from the students table
	 * in the database
	 * @throws SQLException 
	 */
	public List<Student> getStudents() throws SQLException {
		
		List<Student> studentsList = new ArrayList<>();

		// get a connection
		try(Connection connection = dataSource.getConnection()) {

			// create sql statement
			String sql = "select * from student order by last_name";
			Statement statement = connection.createStatement();

			// execute the query
			ResultSet resultSet = statement.executeQuery(sql);

			// process the result set
			while(resultSet.next()) {
				
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

}
