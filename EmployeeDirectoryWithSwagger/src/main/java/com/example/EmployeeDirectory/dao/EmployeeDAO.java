package com.example.EmployeeDirectory.dao;

import java.util.List;

import com.example.EmployeeDirectory.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void delete(int theId);

}
