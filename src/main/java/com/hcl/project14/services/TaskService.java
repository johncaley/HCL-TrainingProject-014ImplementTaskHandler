package com.hcl.project14.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.project14.entities.User;
import com.hcl.project14.entities.Task;
import com.hcl.project14.repositories.TaskRepository;


@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	

	public Optional<Task> GetTaskById(Integer taskId) {
		
		//TODO: create exception for task not found.
		return taskRepository.findById(taskId);
	}
	
	public List<Task> GetTasksByUser(User user) {
		//TODO: what do we do if the user doesn't have any tasks or doesn't exist?
		
		return(taskRepository.findAllByUser(user));
	}
	
	public Task GetTaskByName(String name) {
		return taskRepository.findByName(name);
	}
	
	public Task CreateTask(Task task) {
		return taskRepository.save(task);
	}
	
	public Task UpdateTask(Task task) {
		return taskRepository.save(task);
	}
	
	public void DeleteTask(Task task) {
		taskRepository.delete(task);
	}
}
