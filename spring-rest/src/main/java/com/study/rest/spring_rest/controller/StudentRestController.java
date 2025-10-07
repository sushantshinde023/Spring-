package com.study.rest.spring_rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.rest.spring_rest.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> theStudents=new ArrayList<>();
		theStudents.add(new Student("Appu","Shinne"));
		theStudents.add(new Student("Mark","Rossi"));
		theStudents.add(new Student("Mary","Smith"));
		return theStudents;
	}

}
