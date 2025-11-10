package com.example.EmployeeDirectory.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.EmployeeDirectory.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAO implements EmployeeDAOImpl {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);
		List<Employee> employees=theQuery.getResultList();
		return employees;
	}

}
