package com.example.project_management.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.project_management.dto.Users;
import com.example.project_management.repository.UsersRepository;

@Service
public class CustomUsersDetailsService implements UserDetailsService{
	
	@Autowired
	private UsersRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Users user = userRepository.findByEmail(email).orElseThrow(
				()-> new UsernameNotFoundException(String.format("User with email : %s is not found", email)));
		
		Set<String> roles = new HashSet<String>();
		roles.add("ROLE_ADMIN"); //can give only ADMIN as well
		return new User(user.getEmail(), user.getPassword(), userAuthorities(roles));
	}
	
	private Collection<? extends GrantedAuthority> userAuthorities(Set<String> roles){
		return roles.stream().map(
				role -> new SimpleGrantedAuthority(role)
				).collect(Collectors.toList());
				
	}

}