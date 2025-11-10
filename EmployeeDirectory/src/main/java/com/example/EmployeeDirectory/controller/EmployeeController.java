package com.example.EmployeeDirectory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeDirectory.dao.EmployeeDAO;
import com.example.EmployeeDirectory.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeController(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAll(){
		return employeeDAO.findAll();
	}
	

}
