package com.example.EmployeeDirectory.dao;

import java.util.List;

import com.example.EmployeeDirectory.entity.Employee;

public interface EmployeeDAOImpl {
	
	List<Employee> findAll();

}
