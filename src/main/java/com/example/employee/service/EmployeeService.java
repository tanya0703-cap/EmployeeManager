package com.example.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.employee.entities.Employee;
import com.example.employee.repository.EmployeeRepository;


public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee newEmployee(Employee employee);
	
	Optional<Employee> getEmployeeById(Long id);
	
	Employee updateEmployee(Long id, Employee employeeDetails);
	
	void deleteEmployee(Long id);

	void EmployeeService(EmployeeRepository employeeRepository);
}
