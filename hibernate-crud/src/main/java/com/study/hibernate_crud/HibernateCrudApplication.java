package com.study.hibernate_crud;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.study.hibernate_crud.dao.StudentDao;
import com.study.hibernate_crud.entity.Student;

@SpringBootApplication
public class HibernateCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCrudApplication.class, args);
	}
	
	/*
	 * We are creating Spring boot command line App , this will allow us to focus on Hibernate/JPA
	 * The commandLineRunner is a spring boot bean that implements the CommandLineRunner Interface
	 * It is used to execute custom logic after the application context is initialized & application has started.
	 * */
	/*@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner->{
			System.out.println("Hello World");
		};
	}*/
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner->{
			//createStudent(studentDao);
			//findStudent(studentDao);
			//queryFoeStudents(studentDao);
			//findByLastName(studentDao);
			//updateStudent(studentDao);
			deleteStudent(studentDao);
		};
	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId=3;
		System.out.println("Deleting Student with studentId : "+studentId);
		studentDao.delete(studentId);
		
	}

	private void updateStudent(StudentDao studentDao) {
		//retrieve student based on primary key
		int studentId=1;
		Student theStudent=studentDao.findById(studentId);
		//change firstName to Scooby
		theStudent.setFirstName("Scooby");
		studentDao.update(theStudent);
		//Display student
		System.out.println("Updated Student: "+theStudent);
		
	}

	private void findByLastName(StudentDao studentDao) {
		List<Student> students=studentDao.findByLastName("Patil");
		
		for(Student tempStudent : students) {
			System.out.println(tempStudent);
		}
	}

	private void queryFoeStudents(StudentDao studentDao) {
		List<Student> students=studentDao.findAll();
		//display students
		for(Student student:students) {
			System.out.println(student);
		}
		
	}

	private void findStudent(StudentDao studentDao) {
System.out.println("Creating STudent");
		
		Student theStudent=new Student("Sush","Shinde","sush@gmail.com");
		
		//save student object
		System.out.println("Saving Student object");
		studentDao.save(theStudent);
		//display id of saved student
		System.out.println("Generated id "+theStudent.getId());
		//Retrieve student based on id
		Student myStudent=studentDao.findById(theStudent.getId());
		//Print student
		System.out.println(myStudent);
		
	}

	private void createStudent(StudentDao studentDao) {
		System.out.println("Creating STudent");
		
		Student theStudent=new Student("Sushant","Shinde","sush@gmail.com");
		
		//save student object
		System.out.println("Saving Student object");
		studentDao.save(theStudent);
		
		//display id of saved student
		System.out.println("Generated id "+theStudent.getId());
		
	}
	
	
	
	
	

}
