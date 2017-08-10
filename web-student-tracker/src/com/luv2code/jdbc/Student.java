/**
 * 
 */
package com.luv2code.jdbc;

/**
 * @author Salman Shaikh
 *
 */
public class Student {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * This constructor uses all fields
	 */
	public Student(int id, String firstName, String lastName, String email) {		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * This constructor uses all fields except id
	 */
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
	

}
