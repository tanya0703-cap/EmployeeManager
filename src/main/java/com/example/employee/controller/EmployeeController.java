package com.example.employee.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entities.Employee;
import com.example.employee.service.EmployeeService;
import com.example.employee.utils.Constants;
import com.example.employee.utils.JwtUtils;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Create a new employee
	@PostMapping("/create")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee,
			@RequestHeader(value = "Authorization", required = true) String jwt) {
		String token = JwtUtils.trimBearerToken(jwt);
		if (!token.equalsIgnoreCase(Constants.SECRET_VALUE)) {
			return new ResponseEntity<>("Invalid Authorization Token", HttpStatus.UNAUTHORIZED);
		}

		employeeService.newEmployee(employee);
		return new ResponseEntity<>("Employee Created", HttpStatus.CREATED);
	}
	
	// Read operations
	@GetMapping("/fetch-employees")
	public ResponseEntity<?> getAllEmployees(@RequestHeader(value = "Authorization", required = true) String jwt) {
		List<Employee> allEmployees = new ArrayList<>();
		String token = JwtUtils.trimBearerToken(jwt);
		if (!token.equalsIgnoreCase(Constants.SECRET_VALUE)) {
			return new ResponseEntity<>("Invalid Authorization Token", HttpStatus.UNAUTHORIZED);
		}
		allEmployees = employeeService.getAllEmployees();
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}
	

	@GetMapping("employee-id/{id}")
	public ResponseEntity<?> getBookById(@PathVariable("id") Long id,
			@RequestHeader(value = "Authorization", required = true) String jwt) {
		String token = JwtUtils.trimBearerToken(jwt);
		if (!token.equalsIgnoreCase(Constants.SECRET_VALUE)) {
			return new ResponseEntity<>("Invalid Authorization Token", HttpStatus.UNAUTHORIZED);
		}

		Optional<Employee> employee = employeeService.getEmployeeById(id);
		if (employee.isEmpty()) {
			return new ResponseEntity<>("There is no employee with requested id present", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	

	// Update operation
	@PutMapping("update/{id}")
	public ResponseEntity<?> updateBook(@PathVariable("id") Long id, @Valid @RequestBody Employee employee,
			@RequestHeader(value = "Authorization", required = true) String jwt) {
		String token = JwtUtils.trimBearerToken(jwt);
		if (!token.equalsIgnoreCase(Constants.SECRET_VALUE)) {
			return new ResponseEntity<>("Invalid Authorization Token", HttpStatus.UNAUTHORIZED);
		}
		employeeService.updateEmployee(id, employee);
		return new ResponseEntity<>("Updated the requested employee", HttpStatus.OK);
	}
	


	// Delete operation
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") Long id,
			@RequestHeader(value = "Authorization", required = true) String jwt) {
		String token = JwtUtils.trimBearerToken(jwt);
		if (!token.equalsIgnoreCase(Constants.SECRET_VALUE)) {
			return new ResponseEntity<>("Invalid Authorization Token", HttpStatus.UNAUTHORIZED);
		}
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Deleted the requested item", HttpStatus.NO_CONTENT);
	}
}


