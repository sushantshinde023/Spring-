package com.example.SpringSecurityCustomizedEx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SpringSecurityCustomizedEx.dao.UserRepo;
import com.example.SpringSecurityCustomizedEx.model.Users;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTService jwtService;
	
	private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
	
	
	public Users register(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
	
	public String veriefyUser(Users user) {
		Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername()); 
		}
		return "fail";
	}
}
