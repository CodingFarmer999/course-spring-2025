package com.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.entity.GameHistoryEntity;

@Repository
public interface GameHistoryRepository extends JpaRepository<GameHistoryEntity, Long> {

	List<GameHistoryEntity> findByGameId(Long gameId);

}
