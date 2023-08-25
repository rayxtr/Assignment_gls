package com.lib.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.Exception.EmployeeNotFoundException;
import com.lib.entity.Employee;
import com.lib.repo.EmployeeRepo;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepo er;
	
	@GetMapping
	public String getAllEmployee()throws EmployeeNotFoundException{
		List<Employee> emp = er.findAll();
		if(emp.isEmpty()) {
			throw new EmployeeNotFoundException("No employees found on database...");
		}
		
		String output = emp.stream().map(em->"Name: "+em.getEmpName()+" Age : "+em.getEmpAge()).collect(Collectors.joining("\n"));
		return output;
	}
	
}
