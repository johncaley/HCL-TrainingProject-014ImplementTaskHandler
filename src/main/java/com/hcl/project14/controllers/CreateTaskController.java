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
public class CreateTaskController {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private TaskService taskService;

	@RequestMapping(value="createTasks", method=RequestMethod.POST)
	public String createTask() {
		return "createTask";
	}
	
	@RequestMapping(value="createNewTask", method=RequestMethod.POST)
	public String createNewTask(@RequestParam String Username, String taskName, LocalDate startDate, LocalDate endDate, String severity, String description,  ModelMap model) {

		User user = userService.GetUserByName(Username);
		
		Task task = new Task(taskName, startDate, endDate, severity, description, user);
		
		task = taskService.CreateTask(task);
		
		List<Task> tasks = taskService.GetTasksByUser(user);
		
		model.addAttribute("User", user);
		model.addAttribute("Tasks", tasks);
		
		return "displayTasks";
	}
}
