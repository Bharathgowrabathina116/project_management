package com.example.project_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.project_management.dto.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	// Raw SQL query to fetch task names that start with 'sf'
    @Query(value = "SELECT t FROM Task t WHERE t.task_name LIKE :prefix%")
    List<Task> findTasksByTaskNameStartingWith(@Param("prefix") String prefix);
    
//    @Query(value = "SELECT * FROM Task t WHERE t.taskname = :prefix", nativeQuery = true)
//    List<Task> findTasksByTaskNameStartingWith(@Param("prefix") String prefix);
    
}
