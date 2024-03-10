package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;
import com.example.demo.exception.TaskException;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskServiceImplementation implements TaskService{

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Task createTask(Task task) throws TaskException{
			task=taskRepository.save(task);
			return task;
	}

	@Override
	public Task getTaskById(Long taskId) throws TaskException{
		if(taskRepository.existsById(taskId)) {
			Task task=taskRepository.findById(taskId).get();
			return task;
		}
		else {
			throw new TaskException("Not Exists!");
		}
	}

	@Override
	public List<Task> getAllTasks()  throws TaskException{
		if(taskRepository.equals(null)) {
			throw new TaskException("Not Exists!");
		}
		else {
			return taskRepository.findAll();
		}
	}

	@Override
	public Task updateTask(Long taskId, Task task) throws TaskException{
		Task Ntask=new Task();
		if(taskRepository.existsById(taskId)) {
			task.setTask_id(taskId);
			Ntask.setEndDate(task.getEndDate());
			taskRepository.save(Ntask);
			return Ntask;
		}
		else {
		   throw new TaskException(taskId + " Is Not Exist!");
		}
	}

	@Override
	public String deleteTask(Long taskId) throws TaskException{
		if(taskRepository.existsById(taskId)) {
			taskRepository.deleteById(taskId);
			return "Successfully Deleted!";
		}
		else {
			throw new TaskException("Not Exists!");
		}
	}

	
}
