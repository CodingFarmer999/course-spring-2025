package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.entity.GameEntity;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {

}
