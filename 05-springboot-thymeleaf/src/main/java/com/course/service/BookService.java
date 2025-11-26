package com.course.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.BookEntity;
import com.course.model.BookVo;
import com.course.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookServiceHelper helper;
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<BookVo> getAllBooks() {
		List<BookEntity> books = bookRepo.findAll();
		return books.stream().map(entity -> helper.convertToVo(entity)).collect(Collectors.toList());
	}
	
	/**
	 * 依照 Id 查詢書籍
	 * @param id
	 * @return
	 */
	public BookVo getBookById(Long id) {
		return bookRepo.findById(id).map(helper::convertToVo).orElse(null);
	}
	
	public void deleteById(Long id) {
		bookRepo.deleteById(id);
	}
	
	public void addBook(BookVo book) {
		BookEntity entity = helper.convertToVo(book);
		bookRepo.save(entity);
		try {
			helper.saveImage(book.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBook(BookVo book) {
		
		BookEntity entity = bookRepo.findById(book.getId()).orElse(null);
		if (!book.getName().isBlank()) {
			entity.setName(book.getName());
		}
		
		if (!book.getAuthor().isBlank()) {
			entity.setAuthor(book.getAuthor());
		}
		
		if (!book.getBuyDate().isBlank()) {
			entity.setBuyDate(helper.parseDate(book.getBuyDate()));
		}
		bookRepo.save(entity);
//		try {
//			helper.saveImage(book.getFile());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	

}
