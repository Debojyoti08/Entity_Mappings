package com.main.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Employee;
import com.main.entity.Project;
import com.main.repository.EmployeeRepository;
import com.main.repository.ProjectRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	private ProjectRepository projrepo;
	
	public void saveEmployee(Employee emp) {
		repo.save(emp);
	}
	
	public List<Employee> getEmployeeDetails(Long empId) {
		if (null != empId) {
			return repo.findAllByEmpId(empId);
		} else {
			return repo.findAll();
		}
	}
	
	public void deleteEmployee(Long empId) {
		repo.deleteById(empId);
	}

	public Employee assignProjectToEmployee(Long empId, Long projectId) {
		Set<Project> projectSet = null;
		Employee employee = repo.findById(empId).get();
		Project project = projrepo.findById(projectId).get();
		projectSet = employee.getAssignedProjects();
		projectSet.add(project);
		employee.setAssignedProjects(projectSet);
		return repo.save(employee);
	}
}
