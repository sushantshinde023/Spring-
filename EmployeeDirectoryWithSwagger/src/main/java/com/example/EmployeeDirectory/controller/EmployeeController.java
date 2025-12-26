package com.example.EmployeeDirectory.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeDirectory.entity.Employee;
import com.example.EmployeeDirectory.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	private EmployeeService employeeService;
	private ObjectMapper objectMapper;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService,  ObjectMapper objectMapper) {
		super();
		this.employeeService = employeeService;
		this.objectMapper=objectMapper;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee=employeeService.findById(employeeId);
		if(theEmployee == null) {
			throw new RuntimeException("Employee is not found : "+employeeId);
		}
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		//just in case if user pass an id in JSON..set id to 0 bcoz we are using merge in dao layer , if it found id it will try to update 
		//this is to force a save of new item ...instead of update
		theEmployee.setId(0);//if you have  private int id that is primitive then we can use this. I we use Integer the we will have to use setId(null)
		Employee dbEmployee=employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee tehEmployee) {
		Employee dbEmployee=employeeService.save(tehEmployee);
		return dbEmployee;
	}
	
	@PatchMapping("/employees/{employeeId}")
	public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload) {
		Employee tempEmployee=employeeService.findById(employeeId);
		if(tempEmployee == null) {
			throw new RuntimeException("Employee id not found - "+employeeId);
		}
		
		if(patchPayload.containsKey("id")) {
			throw new RuntimeException("Patch payload should not contain primary key id "+employeeId);
		}
		
		Employee patchedEmployee=apply(patchPayload,tempEmployee);
		Employee dbEmployee=employeeService.save(patchedEmployee);
		return dbEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = employeeService.findById(employeeId);
		if(tempEmployee==null) {
			throw new RuntimeException("Employee id not found - "+employeeId);
		}
		
		employeeService.delete(employeeId);
		return "Deleted Employee Id -"+employeeId;
	}

	private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee) {
		// TODO Auto-generated method stub
		ObjectNode employeeNode= objectMapper.convertValue(tempEmployee, ObjectNode.class);
		
		ObjectNode patchNode= objectMapper.convertValue(patchPayload, ObjectNode.class);
		
		employeeNode.setAll(patchNode);
		
		return objectMapper.convertValue(employeeNode, Employee.class);
	}

}
