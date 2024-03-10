package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Project;
import com.example.demo.entity.Status;
import com.example.demo.entity.Task;
import com.example.demo.exception.ProjectException;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.TaskRepository;

@Service
public class ProjectServiceImplementation implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Project CreateProject(Project project) throws ProjectException{
		// TODO Auto-generated method stub
		Optional<Project> nProject=projectRepository.findByTitle(project.getTitle());
		if(nProject.isPresent()) {
			throw new ProjectException("Project Already Exist With Title: " + project.getTitle());
		}
		else {
			Project newProject = new Project();
	        newProject.setTitle(project.getTitle());
	        newProject.setStartDate(project.getStartDate());
	        newProject.setEndDate(project.getEndDate());
	        newProject.setStatus(Status.ACTIVE);
	        List<Task> tasks=taskRepository.findAll();
	        newProject.setTasks(tasks);
	        newProject.setUsers(project.getUsers());
	        
	        // Save the new project to the database
	        projectRepository.save(newProject);
	        
	        // Return the newly created project
	        return newProject;
		}
	}

	@Override
	public Optional<Project> ViewProjectWithId(Long project_id) throws ProjectException{
		if(projectRepository.existsById(project_id)) {
		      return projectRepository.findById(project_id);
		}
		else {
			throw new ProjectException(project_id + " Is Invalid Id! ");
		}
	}

	@Override
	public List<Project> GetAllProjects() throws ProjectException{
		if(projectRepository.equals(null)) {
			throw new ProjectException("No Projects Exist!");
		}
		else {
			return projectRepository.findAll();
		}
	}

	@Override
	public Project UpdateProjectExist(Project project) {
		Long project_id=project.getProject_id();
	    Project existingProject = projectRepository.findById(project_id)
	            .orElseThrow(() -> new ProjectException("Project not found with ID: " + project_id));
	    
		    existingProject.setTitle(project.getTitle());
		    existingProject.setEndDate(project.getEndDate());
		    existingProject.setStatus(project.getStatus());
		    
		    return projectRepository.save(existingProject);
	    
	}

	@Override
	public String DeleteProjectWithId(Long project_id) {
		
		if(projectRepository.existsById(project_id)) {
			projectRepository.deleteById(project_id);
			return "Successfully Deleted!";
		}
		else {
			return "Project is Not Exist!";	
		}
	}
	

}
