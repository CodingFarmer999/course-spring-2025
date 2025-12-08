package com.course.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		book.setId(rs.getLong("ID"));
		book.setName(rs.getString("NAME"));
		book.setAuthor(rs.getString("AUTHOR"));
		book.setBuyDate(rs.getDate("BUY_DATE"));
		book.setImgName(rs.getString("IMG_NAME"));
		return book;
	}

}
