package com.course.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.model.BookVo;
import com.course.service.BookService;

import jakarta.validation.Valid;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "<span style=\"color:DodgerBlue;\">去唱卡拉ＯＫ吧</span>");

		return "index";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {
		// TODO: 登入行為
		return "loginSuccess";
	}
	
	@GetMapping("/toBookcase")
	public String toBookcase(Model model) {
		// 查詢所有書籍
		List<BookVo> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		
		return "bookcase";
	}
	
	@GetMapping("/books")
	public String listBooks(
	        @RequestParam(defaultValue = "0") Integer page,
	        @RequestParam(defaultValue = "4") Integer size,
	        @RequestParam(defaultValue = "") String keyword,
	        Model model) {

		Page<BookVo> bookPage = bookService.findBookListPaging(page, size, keyword);

	    model.addAttribute("bookPage", bookPage);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("keyword", keyword);

	    return "bookcase2";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable Long id) {
		bookService.deleteById(id);
		return "redirect:/toBookcase";
	}
	
	@GetMapping("/edit/{id}")
	public String toEditPage(@PathVariable Long id, Model model) {
		BookVo book = bookService.getBookById(id);
		model.addAttribute("book", book);
		return "editBook";
	}
	
	@GetMapping("/addBook")
	public String toAddPage(Model model) {
		BookVo book = new BookVo();
		// 預設日期為今天
		book.setBuyDate(parseDateToString(new Date()));
		model.addAttribute("book", book);
		return "addBook";
	}
	
	@PostMapping("/book")
	public String addBook(@Valid @ModelAttribute("book") BookVo book, BindingResult bindingResult, Model model) {
		
		// 新增書籍邏輯
		System.out.println(book);
	    if (bindingResult.hasErrors()) {
	    	model.addAttribute("book", book);
	    	return "addBook";
	    }
	    
		bookService.addBook(book);
		return "redirect:/toBookcase";
	}
	
	@PostMapping("/update")
	public String updateBook(@ModelAttribute BookVo book) {
		// 新增書籍邏輯
		System.out.println(book);
		bookService.updateBook(book);
		return "redirect:/toBookcase";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam String keyword, Model model) {
		
		List<BookVo> books = bookService.findByKeyword(keyword);
		model.addAttribute("books", books);
		
		return "bookcase";
	}
	
	private String parseDateToString(Date date) {
		// 定義日期格式
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
       // 將 Date 物件轉換為 String
       return formatter.format(date);
	}
	
}
