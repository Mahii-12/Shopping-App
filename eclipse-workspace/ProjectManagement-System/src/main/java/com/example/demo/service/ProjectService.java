package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Project;

public interface ProjectService {

	public Project CreateProject(Project project);
	public Optional<Project> ViewProjectWithId(Long project_id);
	public List<Project> GetAllProjects();
	public Project UpdateProjectExist(Project project);
	public String DeleteProjectWithId(Long project_id);
}
