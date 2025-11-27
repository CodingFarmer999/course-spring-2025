package com.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.course.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>{

	List<BookEntity> findByNameContaining(String keyword);
	
	@Query("select b from BookEntity b where b.name like :keyword or b.author like :keyword")
	List<BookEntity> findByKeyword(String keyword);

}
