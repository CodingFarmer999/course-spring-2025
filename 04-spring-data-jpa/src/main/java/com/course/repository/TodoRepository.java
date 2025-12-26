package com.course.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.course.entity.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {

	// SQL語句：select * from todo where status = ?
	List<TodoEntity> findByStatus(Integer status);
	
	// SQL語句：select * from todo where title = ?
	List<TodoEntity> findByTitle(String title);
	
	// SQL語句：select * from todo where title like '%關鍵字%'
	List<TodoEntity> findByTitleLike(String title);
	
	// SQL語句：select * from todo where title like '%關鍵字%'
	List<TodoEntity> findByTitleContaining(String title);

	// SQL語句：select * from todo where title like '關鍵字%'
	List<TodoEntity> findByTitleStartingWith(String title);

	// SQL語句：select * from todo where title like '%關鍵字'
	List<TodoEntity> findByTitleEndingWith(String title);
	
	// SQL語句：select * from todo where id > ?
	List<TodoEntity> findByIdGreaterThan(Integer id);

	// SQL語句：select * from todo where id <= ?
	List<TodoEntity> findByIdLessThanEqual(Integer id);
	
	// SQL語句：select * from todo where duedate between ? and ?
	// 意同：select * from todo where duedate >= ? and duedate <= ?
	List<TodoEntity> findByDuedateBetween(Date startdate, Date endDate);
	
	// SQL語句：select * from todo where status = ? and title = ?
	List<TodoEntity> findByStatusAndTitle(Integer status, String title);

	// SQL語句：select * from todo where status = ? or title = ?
	List<TodoEntity> findByStatusOrTitle(Integer status, String title);
	
	// SQL語句：select * from todo order by duedate;
	List<TodoEntity> findAllByOrderByDuedate();

	// SQL語句：select * from todo order by duedate desc;
	List<TodoEntity> findAllByOrderByDuedateDesc();

	// SQL語句：select * from todo where title like ? order by due_date desc;
	List<TodoEntity> findByTitleStartingWithOrderByDuedateDesc(String title);
	
	@Query("SELECT t FROM TodoEntity t WHERE t.status = 0")
	List<TodoEntity> findByQuery();
	
	// JPQL
	// @Query("SELECT t FROM TodoEntity t WHERE t.status = ?1")
	
	@Query(nativeQuery = true, value = "SELECT * FROM TODO T WHERE T.STATUS = ?1")
	List<TodoEntity> findByQuery2(Integer status);
	
}
