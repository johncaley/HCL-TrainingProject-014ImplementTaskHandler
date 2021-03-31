package com.hcl.project14.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private TaskService taskService;

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String home() {
		return "login";
	}
	

	@RequestMapping(value="LoginToServer", method=RequestMethod.POST)
	public String loginPage(@RequestParam String username, String password, ModelMap model) {

		User user = userService.GetUserByName(username);
		
		password = Integer.toString(password.hashCode());
		
		if (!user.getPassword().equals(password))
		{
			model.addAttribute("errorMessage", "Error: Username or Password is invalid");
			return "error";
		}
		else {

			List<Task> tasks = taskService.GetTasksByUser(user);
			
			model.addAttribute("User", user);
			model.addAttribute("Tasks", tasks);
			
			return "displayTasks";
		}
	}
}
