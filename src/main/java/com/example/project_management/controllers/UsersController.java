package com.example.project_management.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	
//	@Cacheable(key = "#id", value="User")
	@GetMapping("/user/{id}")
    public Optional<Users> getUserById(@PathVariable Long id) {
		
        return userService.fetchbyId(id);
    }
	
	@GetMapping("/user/search")
	public List<Users> findByname(@RequestParam(defaultValue = "") String name) {
	
		return userService.getbyName(name);
	}
	
	@GetMapping("/sample")
	@Cacheable("users")
	public int sampleFun() {
		System.out.println("Sample data will be stored in Cache ");
		return 3;
	}
	
	@PutMapping("/sample")
	@CachePut("users")
	public int sampleFun2() {
		System.out.println("Sample data updated in Cache ");
		return 2;
	}
	@DeleteMapping("/sample")
	@CacheEvict("users")
	public void sampleFun3() {
		System.out.println("Sample data deleted in Cache ");
		
	}
	
//	@PostMapping
//	public void createTask(@RequestBody Task task) {
//		taskrepo.save(task);
//		
//	}
	
	
}
