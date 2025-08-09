package com.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Employee;
import com.main.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		service.saveEmployee(emp);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value = {"/getEmployee", "/{empId}"})
	public List<Employee> getEmployee(@PathVariable(required = false) Long empId) {
		return service.getEmployeeDetails(empId);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity removeEmployee(@PathVariable Long empId) {
		service.deleteEmployee(empId);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping("/{empId}/project/{projectId}")
	public Employee assignProjectToEmployee (
			@PathVariable Long empId,
			@PathVariable Long projectId)
	{
		return service.assignProjectToEmployee(empId, projectId);
	}
}
