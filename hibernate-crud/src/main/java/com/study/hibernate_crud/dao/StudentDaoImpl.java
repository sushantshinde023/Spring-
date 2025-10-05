package com.study.hibernate_crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.hibernate_crud.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query=entityManager.createQuery("from Student",Student.class);
		return  query.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> query=entityManager.createQuery("from Student where lastName=:theData",Student.class);
		query.setParameter("theData", lastName);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Student theStudent = entityManager.find(Student.class, id);
		entityManager.remove(theStudent);	
	}
	

}
