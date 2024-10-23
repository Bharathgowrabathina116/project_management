package com.example.project_management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project_management.dto.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	
	// Automatically derived query to find a task by its name
    List<Users> findByName(String user_name);

	Optional<Users> findByEmail(String email);
}
