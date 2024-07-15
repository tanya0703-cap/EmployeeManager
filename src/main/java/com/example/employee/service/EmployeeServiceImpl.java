package com.example.employee.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entities.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

    @Override
    public void EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Create operation
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Read operation
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Read operation
    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Update operation
    @Override
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setEmployeeName(employeeDetails.getEmployeeName());
            existingEmployee.setSalary(employeeDetails.getSalary());
            existingEmployee.setDepartmentName(employeeDetails.getDepartmentName());
            existingEmployee.setDbUpdateDate(new Date()); // Update the update date
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    // Delete operation
    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

	@Override
	public Employee newEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
}
