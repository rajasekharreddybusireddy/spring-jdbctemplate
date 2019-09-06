package com.javabyrajasekhar.SpringJdbcTemplate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javabyrajasekhar.SpringJdbcTemplate.Employee;
@Service
public interface EmployeeService {
	public void addEmployee(Employee employee);
	 
    public void editEmployee(Employee employee, int employeeId);
 
    public void deleteEmployee(int employeeId);
 
    public Employee find(int EmployeeId);
 
    public List <Employee> findAll();
}
