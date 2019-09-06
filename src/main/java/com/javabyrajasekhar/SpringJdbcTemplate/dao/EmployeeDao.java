package com.javabyrajasekhar.SpringJdbcTemplate.dao;

import java.util.List;

import com.javabyrajasekhar.SpringJdbcTemplate.Employee;

public interface EmployeeDao {
	public void addEmployee(Employee employee);
	 
    public void editEmployee(Employee employee, int employeeId);
 
    public void deleteEmployee(int employeeId);
 
    public Employee find(int EmployeeId);
 
    public List <Employee> findAll();
}
