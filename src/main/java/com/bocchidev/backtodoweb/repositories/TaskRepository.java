package com.bocchidev.backtodoweb.repositories;

import com.bocchidev.backtodoweb.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
