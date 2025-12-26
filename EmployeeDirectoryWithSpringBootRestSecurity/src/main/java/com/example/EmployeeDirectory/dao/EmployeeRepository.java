package com.example.EmployeeDirectory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeeDirectory.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
