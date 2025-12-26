package com.example.SpringSecurityCustomizedEx.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringSecurityCustomizedEx.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	
	private List<Student> listOfStudents= new ArrayList<>(List.of(new Student(1,"abc",99),
			new Student(2,"mno",98),
			new Student(3,"xyz",97)
			));
	
	@GetMapping("students")
	public List<Student> getStudents(){
		
		return listOfStudents;
	}
	
	@GetMapping("csrf-token")
	public CsrfToken getToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
		
	}
	
	@PostMapping("students")
	public Student addStudent(@RequestBody Student student){
		listOfStudents.add(student);
		return student;
	}

}
