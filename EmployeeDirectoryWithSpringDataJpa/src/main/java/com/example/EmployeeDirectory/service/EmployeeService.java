package com.example.EmployeeDirectory.service;

import java.util.List;

import com.example.EmployeeDirectory.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void delete(int theId);

}
