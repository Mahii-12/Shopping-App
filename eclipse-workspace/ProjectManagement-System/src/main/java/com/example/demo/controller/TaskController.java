package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskServiceImplementation;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskServiceImplementation taskService;
	
	@PostMapping("/create")
	public ResponseEntity<Task> newTask(@Valid @RequestBody Task task){
		Task new_task=taskService.createTask(task);
		return new ResponseEntity<>(new_task,HttpStatus.CREATED);
	}
	
	@GetMapping("allTasks")
	public ResponseEntity<List<Task>> allTasks(){
		List<Task> all=taskService.getAllTasks();
		return new ResponseEntity<>(all, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{task_id}")
	public ResponseEntity<Task> getSingleTask(@PathVariable Long task_id){
		Task single=taskService.getTaskById(task_id);
		return new ResponseEntity<>(single, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Task> modExist(@PathVariable Long task_id,@Valid @RequestBody Task task){
		Task new_task=taskService.updateTask(task_id, task);
		return new ResponseEntity<>(new_task, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/remove/{task_id}")
	public ResponseEntity<String> removeTask(@PathVariable Long task_id){
	   String task=taskService.deleteTask(task_id);
	   return new ResponseEntity<>(task, HttpStatus.OK);
	}
}























