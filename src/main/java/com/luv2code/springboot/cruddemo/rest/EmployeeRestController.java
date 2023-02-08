package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeDAO employeeDAO; 
	
	
	//quick and dirty:inject employee dao use constructor injection
	@Autowired
	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		theEmployeeDAO=employeeDAO;
	}
	
	
	//expose "/employee" and return list of employee
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeDAO.findAll();
	}
	
	
	
	

}
