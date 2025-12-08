package com.course.dao;

import java.util.List;

import com.course.model.Book;
import com.course.model.BookDto;

public interface BookDao {

	Book findById(Long id);
	
	void insert(Book book);
	
	void update(Book book);
	
	void delete(Long id);

	List<BookDto> findBookByStore(String code);
}
