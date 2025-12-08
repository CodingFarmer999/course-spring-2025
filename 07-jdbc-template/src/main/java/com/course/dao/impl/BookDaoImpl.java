package com.course.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.course.dao.BookDao;
import com.course.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Book findById(Long id) {
		String sql = "SELECT * FROM BOOK B WHERE B.ID = ?";
		
		RowMapper<Book> rowMapper = new RowMapper<>() {
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
		};
		List<Book> books = jdbcTemplate.query(sql, rowMapper, id);
		
		return books != null && books.size() > 0 ? books.get(0) : null;
	}

	@Override
	public void insert(Book book) {
		String sql = "INSERT INTO BOOK (NAME, AUTHOR, BUY_DATE, IMG_NAME) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getBuyDate(), book.getImgName());
	}

	@Override
	public void update(Book book) {
		String sql = "UPDATE BOOK SET NAME = ?, AUTHOR = ? , BUY_DATE = ? , IMG_NAME= ? WHERE ID = ?";
		jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getBuyDate(), book.getImgName(), book.getId());
		
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM BOOK WHERE ID = ?";
		jdbcTemplate.update(sql, id);
	}

}
