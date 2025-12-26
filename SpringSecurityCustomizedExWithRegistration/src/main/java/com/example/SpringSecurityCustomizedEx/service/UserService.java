package com.example.SpringSecurityCustomizedEx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SpringSecurityCustomizedEx.dao.UserRepo;
import com.example.SpringSecurityCustomizedEx.model.Users;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
	
	
	public Users register(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
}
