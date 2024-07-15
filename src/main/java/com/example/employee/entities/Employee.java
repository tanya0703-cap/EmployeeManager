package com.example.employee.entities;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long employeeId;
	
    private String employeeName;
    private Double salary;
    private String departmentName;
    private Date dbUpdateDate;
    
    
	public Employee() {
		super();
	}


	public Employee(Long employeeId, String employeeName, Double salary, String departmentName, Date dbUpdateDate) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.departmentName = departmentName;
		this.dbUpdateDate = dbUpdateDate;
	}


	public Long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public Date getDbUpdateDate() {
		return dbUpdateDate;
	}


	public void setDbUpdateDate(Date dbUpdateDate) {
		this.dbUpdateDate = dbUpdateDate;
	}


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary
				+ ", departmentName=" + departmentName + ", dbUpdateDate=" + dbUpdateDate + ", getEmployeeId()="
				+ getEmployeeId() + ", getEmployeeName()=" + getEmployeeName() + ", getSalary()=" + getSalary()
				+ ", getDepartmentName()=" + getDepartmentName() + ", getDbUpdateDate()=" + getDbUpdateDate()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
    
    
}
