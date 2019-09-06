package com.javabyrajasekhar.SpringJdbcTemplate;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.javabyrajasekhar.SpringJdbcTemplate.config.ApplicationConfig;
import com.javabyrajasekhar.SpringJdbcTemplate.service.EmployeeService;

public class App {

	public static void main(String[] args) {
		  AbstractApplicationContext container = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		  EmployeeService employeeService = (EmployeeService) container.getBean("employeeService");
		  addEmployee(employeeService);
			Scanner scanner = new Scanner(System.in);
			System.out.println("enter Employee id ...");
			int id=Integer.parseInt(scanner.nextLine());
		  updateEmployee(employeeService, id);
		  
		  getEmployee(employeeService, id);
		
		  getAllEmployees(employeeService);
		  
	}

	private static void getEmployee(EmployeeService employeeService, int id) {
		Employee employee = employeeService.find(id);
		  System.out.println(" ---------------------------find employee---------------------------");
			System.out.println(" id :- "+employee.getId());
			System.out.println(" id :- "+employee.getName());
			System.out.println(" id :- "+employee.getSalary());
			
			 System.out.println(" ------------------------------------------------------");
		
	}

	private static void updateEmployee(EmployeeService employeeService, int id) {
		Employee employee = employeeService.find(id);
		  if(employee !=null) {
			  System.out.println("---------------------------update Employee-----------------------------");
			  Scanner scanner = new Scanner(System.in);
				System.out.println("enter Employee name ...");
				employee.setName(scanner.nextLine());
				System.out.println("enter Employee salary ...");
				employee.setSalary(Double.parseDouble(scanner.nextLine()));
			  employeeService.editEmployee(employee, id);
			  System.out.println(" ------------------------------------------------------");
		  }
	}

	@SuppressWarnings("resource")
	private static void addEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		System.out.println("---------------------------add Employee-----------------------------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter Employee id ...");
		employee.setId(Integer.parseInt(scanner.nextLine()));
		System.out.println("enter Employee name ...");
		employee.setName(scanner.nextLine());
		System.out.println("enter Employee salary ...");
		employee.setSalary(Double.parseDouble(scanner.nextLine()));
		employeeService.addEmployee(employee);
		
		 System.out.println(" ------------------------------------------------------");
	}

	private static void getAllEmployees(EmployeeService employeeService) {
		List<Employee> findAll = employeeService.findAll();
		 System.out.println(" ------------------------------getAllEmployees--------------------------");
		  for (Employee employee : findAll) {
			System.out.println(" id :- "+employee.getId());
			System.out.println(" id :- "+employee.getName());
			System.out.println(" id :- "+employee.getSalary());
			 System.out.println(" ........................................");
		}
		  System.out.println(" ------------------------------------------------------");
	}

}
