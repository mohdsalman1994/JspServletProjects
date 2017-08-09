/**
 * 
 */
package com.luv2code.servletdemo.mvctwo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Salman Shaikh
 *
 */
public class StudentDataUtil {
	
	/**
	 * @return a list of sample students 
	 */
	public static List<Student> getStudentsList() {
		
		
		// create an empty list
		List<Student> studentsList = new ArrayList<>();
		
		// add sample data to students list
		studentsList.add(new Student("Mary", "Public" , "mary@luv2code.com"));
		studentsList.add(new Student("John", "Doe" , "john@luv2code.com"));
		studentsList.add(new Student("Ajay", "Rao" , "ajay@luv2code.com"));
		
		// return the list
		return studentsList;
	}

}
