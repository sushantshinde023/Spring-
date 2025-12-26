package com.example.SpringSecurityCustomizedEx.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.SpringSecurityCustomizedEx.dao.UserRepo;
import com.example.SpringSecurityCustomizedEx.model.UserPrincipal;
import com.example.SpringSecurityCustomizedEx.model.Users;

@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user=userRepo.findByUsername(username);
		
		if(user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("User Not Found "+username);
		}
		
		return new UserPrincipal(user);
	}

}
