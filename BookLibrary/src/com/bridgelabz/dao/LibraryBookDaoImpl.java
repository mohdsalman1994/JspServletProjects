package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bridgelabz.entity.Book;

/**
 * @author Salman Shaikh
 *
 */
public class LibraryBookDaoImpl implements LibraryBookDao {

	private Log logger = LogFactory.getLog(LibraryUserDaoImpl.class);

	// can't use @Resource annotation since this is POJO class. It applies to Java
	// EE elements only.
	private DataSource dataSource;

	/**
	 * @param dataSource
	 *            used to obtain connection to the database
	 */
	public LibraryBookDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/*
	 * @see com.bridgelabz.dao.LibraryBookDao#getBooks(java.lang.Integer,
	 * java.lang.String)
	 */
	@Override
	public List<Book> getBooks(Integer userId, String bookCategory) throws SQLException {

		System.out.println("Inside getBooks");

		List<Book> bookList = null;

		try (Connection connection = dataSource.getConnection()) {

			String sql = "select * from userbooks where uid=? and bookCategory=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, bookCategory);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (bookList == null) {
					bookList = new ArrayList<>();
				}

				String bookName = resultSet.getString("bookname");
				String bookAuthor = resultSet.getString("bookauthor");
				String bookDescription = resultSet.getString("description");

				bookList.add(new Book(bookName, bookAuthor, bookCategory, bookDescription));
				// System.out.println("BookList: " + bookList);
			}
		}
		return bookList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bridgelabz.dao.LibraryBookDao#getBook(java.lang.Integer,
	 * java.lang.String)
	 */
	@Override
	public Book getBook(Integer userId, String bookName) throws SQLException {
		System.out.println("Inside getBook");

		Book book = null;

		try (Connection connection = dataSource.getConnection()) {

			String sql = "select * from userbooks where uid=? and bookName=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, bookName);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String bookAuthor = resultSet.getString("bookauthor");
				String bookCategory = resultSet.getString("bookCategory");
				String bookDescription = resultSet.getString("description");

				book = new Book(bookName, bookAuthor, bookCategory, bookDescription);
			}
			// System.out.println("BookList: " + bookList);
		}
		return book;
	}

}
