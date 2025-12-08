package com.course.dao;

import com.course.model.Book;

public interface BookDao {

	Book findById(Long id);
	
	void insert(Book book);
	
	void update(Book book);
	
	void delete(Long id);
}
