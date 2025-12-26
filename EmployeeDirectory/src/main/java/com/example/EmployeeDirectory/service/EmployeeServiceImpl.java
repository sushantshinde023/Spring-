package com.example.EmployeeDirectory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeDirectory.dao.EmployeeDAOImpl;
import com.example.EmployeeDirectory.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAOImpl employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAOImpl employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}


	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}


	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDao.findById(theId);
	}


	@Override
	@Transactional
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeDao.save(theEmployee);
	}


	@Override
	@Transactional
	public void delete(int theId) {
		// TODO Auto-generated method stu
		employeeDao.delete(theId);
	}

}
