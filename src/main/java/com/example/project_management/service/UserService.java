package com.example.project_management.service;

import com.example.project_management.dto.Users;
import com.example.project_management.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsersRepository userRepo;

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }
    
    public Optional<Users> fetchbyId(long id){
    	return userRepo.findById(id);
    }
    
    public List<Users> getbyName(String name) {
        return userRepo.findByName(name);
    }
    
}