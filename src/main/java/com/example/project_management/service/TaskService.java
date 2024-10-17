package com.example.project_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project_management.dto.Task;
import com.example.project_management.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepo;
	
	public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }
    public List<Task> getTasksStartingWith(String prefix) {
        return taskRepo.findTasksByTaskNameStartingWith(prefix);
    }
}
