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

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class BookController {

	// 為了簡易測試，Controller 直接呼叫Dao，不建議如此設計
	@Autowired
	private BookDao bookDao;
	
	@Operation(summary = "查詢所有書籍", tags = "書籍")
	@GetMapping("/book")
	public List<Book> findAll() {
		return bookDao.findAll();
	}
	
	@Operation(summary = "查詢書籍", tags = "書籍")
	@GetMapping("/book/{id}")
	public Book findById(@PathVariable Long id) {
		return bookDao.findById(id);
	}
	
	@Operation(summary = "新增書籍", tags = "書籍")
	@PostMapping("/book")
	public void insert(@RequestBody Book book) {
		bookDao.insert(book);
	}
	
	@Operation(summary = "更新書籍", tags = "書籍")
	@PutMapping("/book")
	public void update(@RequestBody Book book) {
		bookDao.update(book);
	}
	
	@Operation(summary = "刪除書籍", tags = "書籍")
	@DeleteMapping("/book/{id}")
	public void delete(@PathVariable Long id) {
		bookDao.delete(id);
	}
	
	@Operation(summary = "庫存查詢", tags = "關聯資料")
	@GetMapping("/inventory/store/{code}")
	public List<BookDto> findInventoryByStore(@PathVariable String code) {
		return bookDao.findBookByStore(code);
	}
}
