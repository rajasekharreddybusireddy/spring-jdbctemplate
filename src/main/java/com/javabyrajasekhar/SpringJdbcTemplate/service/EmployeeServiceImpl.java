package com.javabyrajasekhar.SpringJdbcTemplate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabyrajasekhar.SpringJdbcTemplate.Employee;
import com.javabyrajasekhar.SpringJdbcTemplate.dao.EmployeeDao;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	@Override
	public void editEmployee(Employee employee, int employeeId) {
		employeeDao.editEmployee(employee, employeeId);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeDao.deleteEmployee(employeeId);
	}

	@Override
	public Employee find(int EmployeeId) {
		return employeeDao.find(EmployeeId);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

}
