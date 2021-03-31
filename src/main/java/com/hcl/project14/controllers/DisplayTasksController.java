package com.hcl.project14.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.project14.entities.Task;
import com.hcl.project14.entities.User;
import com.hcl.project14.services.TaskService;
import com.hcl.project14.services.UserService;

@Controller
public class DisplayTasksController {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private TaskService taskService;

	@RequestMapping(value="displayTasks", method=RequestMethod.GET)
	public String displayTasks() {
		return "displayTasks";
	}
	
	@RequestMapping(value="CreateTask", method=RequestMethod.POST)
	public String createTask(@RequestParam String username, ModelMap model) {
		
		model.addAttribute("Username", username);
		
		return "createTask";
	}
	
	@RequestMapping(value="UpdateTask", method=RequestMethod.POST)
	public String updateTask(@RequestParam String username, String taskNum, ModelMap model) {
		
		User user = userService.GetUserByName(username);
		
		List<Task> tasks = taskService.GetTasksByUser(user);
		
		int i = Integer.parseInt(taskNum)-1; 
		
		model.addAttribute("Username", username);
		model.addAttribute("Task", tasks.get(i));
		
		return "updateTask";
	}
	
	@RequestMapping(value="DeleteTask", method=RequestMethod.POST)
	public String deleteTask(@RequestParam String username, String taskNum, ModelMap model) {
		
		User user = userService.GetUserByName(username);
		
		List<Task> tasks = taskService.GetTasksByUser(user);
		
		int i = Integer.parseInt(taskNum)-1; 
		
		
		model.addAttribute("Username", username);
		model.addAttribute("TaskNum", taskNum);
		model.addAttribute("Task", tasks.get(i));
		
		return "deleteTask";
	}
}
