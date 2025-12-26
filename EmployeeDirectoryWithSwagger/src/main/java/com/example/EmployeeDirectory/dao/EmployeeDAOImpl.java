package com.example.EmployeeDirectory.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.EmployeeDirectory.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);
		List<Employee> employees=theQuery.getResultList();
		return employees;
	}


	@Override
	public Employee findById(int theId) {
		Employee theEmployee=entityManager.find(Employee.class, theId);
		return theEmployee;
	}


	@Override
	public Employee save(Employee theEmployee) {
		Employee dbEmployee=entityManager.merge(theEmployee);
		return dbEmployee;
	}


	@Override
	public void delete(int theId) {
		Employee theEmployee=entityManager.find(Employee.class, theId);
		entityManager.remove(theEmployee);
		
	}

}
