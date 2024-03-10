package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.demo.entity.Project;
import com.example.demo.service.ProjectServiceImplementation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;

@Api(value = "CRUD Rest APIs for Project resources")
@RestController
@RequestMapping("/project/")
public class ProjectController {

	@Autowired
	private ProjectServiceImplementation projectService;
	
	@ApiOperation(value = "Create Project REST API")
	@PostMapping("/create")
	public ResponseEntity<Project> newProject(@Valid @RequestBody Project project){
		Project new_project=projectService.CreateProject(project);
		return new ResponseEntity<>(new_project, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Get All Projects REST API")
	@GetMapping("/allProjects")
	public ResponseEntity<List<Project>> viewAllProjects(){
		List<Project> all_projects=projectService.GetAllProjects();
		return new ResponseEntity<>(all_projects,HttpStatus.ACCEPTED);
	}
	
	@ApiOperation(value = "Get Project By Id REST API")
	@GetMapping("/getProject/{id}")
	public ResponseEntity<Optional<Project>> viewProject(@PathVariable("id") Long project_id){
		Optional<Project> new_project=projectService.ViewProjectWithId(project_id);
		return new ResponseEntity<>(new_project, HttpStatus.ACCEPTED);
	}
	
	@ApiOperation(value = "Update Project By Id REST API")
	@PutMapping("/update")
	public ResponseEntity<Project> updateProject(@Valid @RequestBody Project project){ 
		Project updated= projectService.UpdateProjectExist(project);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete Project By Id REST API")
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeProject(@PathVariable("id") Long project_id){
		String id=projectService.DeleteProjectWithId(project_id);
		return new ResponseEntity<>(id, HttpStatus.ACCEPTED);
	}
}


















