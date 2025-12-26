package com.example.SpringSecurityCustomizedEx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringSecurityCustomizedEx.model.Users;
import com.example.SpringSecurityCustomizedEx.service.UserService;

@RestController
public class UsreController {

	@Autowired
	private UserService userService;
	
	@PostMapping("user/register")
	public Users register(@RequestBody Users user) {
		return userService.register(user);
	}
	
}
