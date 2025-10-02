package com.study.hibernate_crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.hibernate_crud.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao{
	private EntityManager entityManager;
	
	@Autowired
	public StudentDaoImpl(EntityManager theEntityManager) {
		this.entityManager=theEntityManager;
				
	}

	@Override
	@Transactional
	public void save(Student theStudent) {
		
		entityManager.persist(theStudent);
	}
	

}
