package com.Page.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Page.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
}
