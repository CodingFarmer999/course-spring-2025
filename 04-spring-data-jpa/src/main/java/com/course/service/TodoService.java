package com.course.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.TodoEntity;
import com.course.model.TodoVo;
import com.course.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepo;
	
	/**
	 * 查詢全部
	 * @return
	 */
	public List<TodoEntity> getAllTodo() {
		return todoRepo.findAll();
	}
	
	/**
	 * 依狀態查詢
	 * @param status
	 * @return
	 */
	public List<TodoEntity> getTodoByStatus(Integer status) {
		return todoRepo.findByStatus(status);
	}
	
	/**
	 * 依主題查詢
	 * @param title
	 * @return
	 */
	public List<TodoEntity> getTodoByTitle(String title) {
		// 精準查詢
		// return todoRepo.findByTitle(title);
		
		// 模糊查詢
		String keyword = "%" + title + "%";
		return todoRepo.findByTitleLike(keyword);
	}
	
	/**
	 * 範圍查詢
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<TodoEntity> getTodoBetween(String startDate, String endDate) {
		return todoRepo.findByDuedateBetween(genQueryDate(startDate, false), genQueryDate(endDate, true));
	}
	
	/**
	 * 日期字串轉換
	 * @param dateStr
	 * @param isEndDate
	 * @return
	 */
	private Date genQueryDate(String dateStr, boolean isEndDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			if (isEndDate) {
				date = dateFormat.parse(dateStr + " 23:59:59");
			} else {
				date = dateFormat.parse(dateStr + " 00:00:00");				
			}
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		return date;
	}
	
	public List<TodoEntity> findByQuery(TodoVo todoVo) {
		// return todoRepo.findByQuery();
		return todoRepo.findByQuery2(todoVo.getStatus());
	}
	
	public List<TodoEntity> findByStatusAndDuedate(TodoVo todoVo) {
		Date startDate = genQueryDate(todoVo.getDuedate(), false);
		Date endDate = genQueryDate(todoVo.getDuedate(), true);
		return todoRepo.findByStatusAndDuedate(todoVo.getStatus(), startDate, endDate);
	}
	
	public void insertTodoByQuery(TodoVo todoVo) {
		todoRepo.insertTodo(todoVo.getTitle(), todoVo.getStatus(), genQueryDate(todoVo.getDuedate(), false));
	}
	
	public void updateTodoByQuery(TodoVo todoVo) {
		todoRepo.updateTodo(todoVo.getId(), todoVo.getTitle());
	}
	
	public void deleteTodo(Integer status) {
		todoRepo.deleteByStatus(status);
	}
	
}
