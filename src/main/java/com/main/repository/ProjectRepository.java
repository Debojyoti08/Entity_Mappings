package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>
{
	List<Project> findAllByProjectId(Long projectId);
}
