package com.hcl.project14.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.project14.entities.Task;
import com.hcl.project14.entities.User;
import com.hcl.project14.services.TaskService;
import com.hcl.project14.services.UserService;

public class DeleteTaskController {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private TaskService taskService;

	@RequestMapping(value="deleteTasks", method=RequestMethod.POST)
	public String deleteTasks() {
		return "deleteTask";
	}
	
	@RequestMapping(value="deleteTask", method=RequestMethod.POST)
	public String createNewTask(@RequestParam String Username, String TaskNum, ModelMap model) {
		
		User user = userService.GetUserByName(Username);
		
		List<Task> tasks = taskService.GetTasksByUser(user);
		
		int i = Integer.parseInt(TaskNum)-1; 
		
		taskService.DeleteTask(tasks.get(i));
		
		tasks = taskService.GetTasksByUser(user);
		
		model.addAttribute("User", user);
		model.addAttribute("Tasks", tasks);
		
		return "displayTasks";
	}
}
