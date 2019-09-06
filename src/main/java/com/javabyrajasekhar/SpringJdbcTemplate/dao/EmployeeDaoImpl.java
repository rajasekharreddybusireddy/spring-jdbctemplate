package com.javabyrajasekhar.SpringJdbcTemplate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javabyrajasekhar.SpringJdbcTemplate.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
private final String insert="insert into employee(id,name,salary) values(?,?,?)";
private final String update="update  employee set name=?,salary=? where id=?";
private final String delete="delete from  employee  where id=?";
private final String select="select * from  employee  where id=?";
private final String selectAll="select * from  employee ";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addEmployee(Employee employee) {
		jdbcTemplate.update(insert,employee.getId(),employee.getName(),employee.getSalary());
		System.out.println("employee Added!!");
	}

	@Override
	public void editEmployee(Employee employee, int employeeId) {
		jdbcTemplate.update(update,employee.getName(),employee.getSalary(),employeeId);
		System.out.println("employee updated!!");
	}

	@Override
	public void deleteEmployee(int employeeId) {
		jdbcTemplate.update(delete,employeeId);
		System.out.println("employee deleted!!");
	}

	@Override
	public Employee find(int EmployeeId) {
		Employee employee = (Employee) jdbcTemplate.queryForObject(select,
				new Object[] { EmployeeId }, new BeanPropertyRowMapper(Employee.class));

		return employee;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> emplist = jdbcTemplate.query(selectAll, new BeanPropertyRowMapper(Employee.class));
		return emplist;
	}

}
