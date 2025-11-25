package com.course.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.BookEntity;
import com.course.model.BookVo;
import com.course.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	public List<BookVo> getAllBooks() {
		List<BookEntity> books = bookRepo.findAll();
		return books.stream().map(entity -> convertToVo(entity)).collect(Collectors.toList());
	}
	
	/**
	 * 依照 Id 查詢書籍
	 * @param id
	 * @return
	 */
	public BookVo getBookById(Long id) {
		return bookRepo.findById(id).map(this::convertToVo).orElse(null);
	}
	
	public void deleteById(Long id) {
		bookRepo.deleteById(id);
	}
	
	private BookVo convertToVo(BookEntity entity) {
		BookVo vo = new BookVo();
		vo.setId(entity.getId());
		vo.setName(entity.getName());
		vo.setAuthor(entity.getAuthor());
		return vo;
	}
}
