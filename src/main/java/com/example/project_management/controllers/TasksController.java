package com.example.project_management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_management.dto.Task;
import com.example.project_management.service.TaskService;

@RestController
@RequestMapping("/api/v1")
public class TasksController {
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/tasks")
	public List<Task> get_tasks(){
//		System.out.println(taskrepo.findAll());
		return taskService.getAllTasks();
	}
	@GetMapping("/search/{prefix}")
    public List<Task> getUserBySearchstring(@PathVariable String prefix) {
        return taskService.getTasksStartingWith(prefix);
    }
}
