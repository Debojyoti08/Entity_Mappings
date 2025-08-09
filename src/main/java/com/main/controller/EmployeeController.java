package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Employee;
import com.main.repository.EmployeeRepository;

@RestController
public class EmployeeController 
{
	@Autowired
	private EmployeeRepository repo;
	
	@PostMapping("/saveemp")
	public ResponseEntity<String> saveEmployee(@RequestBody List<Employee> empData) 
	{
		repo.saveAll(empData);
		return ResponseEntity.ok("Data Saved");
	}
}
