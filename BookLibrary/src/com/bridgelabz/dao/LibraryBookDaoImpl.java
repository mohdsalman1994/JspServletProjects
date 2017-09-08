package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bridgelabz.entity.Book;

/**
 * @author Salman Shaikh
 *
 */
public class LibraryBookDaoImpl implements LibraryBookDao {

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

		List<Book> bookList = null;

		try (Connection connection = dataSource.getConnection()) {

			String sql = "select * from userbook where uid=? and bookname=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (bookList == null) {
					bookList = new ArrayList<>();
				}

				String bookName = resultSet.getString("bookname");
				String bookAuthor = resultSet.getString("bookauthor");
				String bookDescription = resultSet.getString("description");

				bookList.add(new Book(bookName, bookAuthor, bookCategory, bookDescription));
			}
		}
		return bookList;
	}

}
