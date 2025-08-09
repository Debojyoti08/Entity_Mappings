package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Project;
import com.main.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository repo;
	
	public void saveProject(Project proj) {
		repo.save(proj);
	}
	
	public List<Project> getProjectDetails(Long projId) {
		if (null != projId) {
			return repo.findAllByProjectId(projId);
		} else {
			return repo.findAll();
		}
	}
	
	public void deleteProject(Long projectId) {
		repo.deleteById(projectId);
	}
}
