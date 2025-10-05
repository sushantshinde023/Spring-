package com.study.hibernate_crud.dao;

import java.util.List;

import com.study.hibernate_crud.entity.Student;

public interface StudentDao {
	void save(Student theStudent);
	Student findById(Integer id);
	List<Student> findAll();
	List<Student> findByLastName(String lastName);
	void update(Student theStudent);
	void delete(Integer id);
}
