package com.example.demo.service;


import java.util.List;

import com.example.demo.entity.Task;

public interface TaskService {

  public Task createTask(Task task);
  public Task getTaskById(Long taskId);
  public List<Task> getAllTasks();
  public Task updateTask(Long taskId, Task task);
  public String deleteTask(Long taskId);
}
