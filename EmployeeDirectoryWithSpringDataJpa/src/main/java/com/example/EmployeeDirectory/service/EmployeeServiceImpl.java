package com.example.EmployeeDirectory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeDirectory.dao.EmployeeRepository;
import com.example.EmployeeDirectory.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		super();
		this.employeeRepository = theEmployeeRepository;
	}


	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}


	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		
		Optional<Employee> result= employeeRepository.findById(theId);//optional tutorial www.luv2code.com/java-optional-tutorial
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee=result.get();
		}else {
			throw new RuntimeException("did not found employee with id - "+theId);
		}
		return theEmployee;
	}


	@Override
	@Transactional
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(theEmployee);
	}


	@Override
	@Transactional
	public void delete(int theId) {
		// TODO Auto-generated method stu
		employeeRepository.deleteById(theId);
	}

}
