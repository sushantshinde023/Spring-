package com.example.SpringSecurityCustomizedEx.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringSecurityCustomizedEx.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);

}
