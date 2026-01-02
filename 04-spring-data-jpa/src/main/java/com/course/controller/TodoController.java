package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.TodoEntity;
import com.course.model.TodoVo;
import com.course.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todo")
	public List<TodoEntity> getTodos() {
		List<TodoEntity> todos = todoService.getAllTodo();
		return todos;
	}
	
	@GetMapping("/todo/status/{status}")
	public List<TodoEntity> getByStatus(@PathVariable Integer status) {
		List<TodoEntity> todos = todoService.getTodoByStatus(status);
		return todos;
	}
	
	@GetMapping("/todo/title/{title}")
	public List<TodoEntity> getByTitle(@PathVariable String title) {
		List<TodoEntity> todos = todoService.getTodoByTitle(title);
		return todos;
	}
	
	@GetMapping("/todo/between")
	public List<TodoEntity> getByBetween(@RequestParam String startDate, @RequestParam String endDate) {
		List<TodoEntity> todos = todoService.getTodoBetween(startDate, endDate);
		return todos;
	}
	
	@PostMapping("/todo/query")
	public List<TodoEntity> findByQuery(@RequestBody TodoVo todoVo) {
		List<TodoEntity> todos = todoService.findByQuery(todoVo);
		return todos;
	}
	
	@PostMapping("/todo/query-stats-and-duedate")
	public List<TodoEntity> findByStatusAndDuedate(@RequestBody TodoVo todoVo) {
		List<TodoEntity> todos = todoService.findByStatusAndDuedate(todoVo);
		return todos;
	}
	
	@PostMapping("/todo/insert-by-query")
	public void insertByQuery(@RequestBody TodoVo todoVo) {
		todoService.insertTodoByQuery(todoVo);
	}
	
	@PostMapping("/todo/update-by-query")
	public void updateByQuery(@RequestBody TodoVo todoVo) {
		todoService.updateTodoByQuery(todoVo);
	}
	
	@PostMapping("/todo/delete-by-status")
	public void updateByQuery(Integer status) {
		todoService.deleteTodo(status);
	}
	
}
