package com.study.hibernate_crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.hibernate_crud.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

/*
 * @Repository : It is sub annotation of @Component. This is applied to DAO Implementation then Spring will automatically register the DAO implementation
 * 				 Spring will also provides translation of  any JDBC related exceptions with @Repository annotation
 * @Transactional : This annotation automagically begin and end a transaction for your JPA code.
 * 
 * */
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
