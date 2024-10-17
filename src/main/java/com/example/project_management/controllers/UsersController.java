package com.example.project_management.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_management.dto.Users;
import com.example.project_management.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UsersController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<Users> get_employees(){
//		System.out.println(taskrepo.findAll());
		return userService.getAllUsers();
	}
	@GetMapping("/{id}")
    public Optional<Users> getUserById(@PathVariable Long id) {
		
        return userService.fetchbyId(id);
    }
	
	@GetMapping("/user/search")
	public List<Users> findByname(@RequestParam(defaultValue = "") String name) {
	
		return userService.getbyName(name);
	}
//	@PostMapping
//	public void createTask(@RequestBody Task task) {
//		taskrepo.save(task);
//		
//	}
	
	
}
