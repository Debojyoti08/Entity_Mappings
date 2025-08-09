package com.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Project;
import com.main.services.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService service;
	
	@PostMapping("/save")
	public ResponseEntity createProject(@RequestBody Project proj) {
		service.saveProject(proj);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@GetMapping(value = {"/getProjects", "/{projId}"})
	public List<Project> getProjects(@PathVariable(required = false) Long projId) {
		return service.getProjectDetails(projId);
	}
	
	@DeleteMapping("/delete/{projId}")
	public ResponseEntity removeProject(@PathVariable Long projId) {
		service.deleteProject(projId);
		return new ResponseEntity(HttpStatus.OK);
	}
}
