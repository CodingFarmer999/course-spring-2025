package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.BookDto;
import com.course.model.BookVo;
import com.course.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<BookDto> getAllBook() {
		return bookService.getAll();	
	}
	
	@GetMapping("/book/{name}")
	public List<BookDto> searchByName(@PathVariable String name) {
		return bookService.searchByName(name);	
	}
	
	@PostMapping("/book")
	public void addBook(BookVo vo) {
		bookService.addBook(vo);
	}
	
	@PatchMapping("/book/author")
	public void updateBook(BookVo vo) {
		bookService.updateAuthor(vo);
	}
	
	@DeleteMapping("/book/{id}")
	public void deleteBookById(Long id) {
		bookService.deleteBook(id);
	}
}
