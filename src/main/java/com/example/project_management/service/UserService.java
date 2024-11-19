package com.example.project_management.service;

import com.example.project_management.dto.Users;
import com.example.project_management.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsersRepository userRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public Users createUser(Users user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

//    @Cacheable(value = "users", key = "'allUsers'")
    public List<Users> getAllUsers() {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Data is fetched from db");
        return userRepo.findAll();
    }
    
    public Optional<Users> fetchbyId(long id){
    	return userRepo.findById(id);
    }
    
    public List<Users> getbyName(String name) {
        return userRepo.findByName(name);
    }
    
}