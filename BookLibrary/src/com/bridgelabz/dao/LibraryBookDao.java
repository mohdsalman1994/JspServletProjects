/**
 * 
 */
package com.bridgelabz.dao;

import java.sql.SQLException;
import java.util.List;

import com.bridgelabz.entity.Book;

/**
 * @author Salman Shaikh
 *
 */
public interface LibraryBookDao {

	/**
	 * @param userId
	 * @param category
	 * @return a list of Books. This method returns a list of Books for the given
	 *         userId and category
	 * @throws SQLException
	 */
	public List<Book> getBooks(Integer userId, String category) throws SQLException;

	public Book getBook(Integer userId, String bookName) throws SQLException;

}
