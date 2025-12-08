package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.dao.BookDao;
import com.course.model.Book;
import com.course.model.BookDto;

@RestController
public class BookController {

	// 為了簡易測試，Controller 直接呼叫Dao，不建議如此設計
	@Autowired
	private BookDao bookDao;
	
	@GetMapping("/book/{id}")
	public Book findById(@PathVariable Long id) {
		return bookDao.findById(id);
	}
	
	@PostMapping("/book")
	public void insert(@RequestBody Book book) {
		bookDao.insert(book);
	}
	
	@PutMapping("/book")
	public void update(@RequestBody Book book) {
		bookDao.update(book);
	}
	
	@DeleteMapping("/book/{id}")
	public void delete(@PathVariable Long id) {
		bookDao.delete(id);
	}
	
	@GetMapping("/inventory/store/{code}")
	public List<BookDto> findInventoryByStore(@PathVariable String code) {
		return bookDao.findBookByStore(code);
	}
}
