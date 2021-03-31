package com.hcl.project14.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.project14.entities.User;
import com.hcl.project14.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	 private UserRepository userRepository;
	
	public User GetUserByName(String name) {
		
		User retrievedUser = userRepository.findByName(name);
		return retrievedUser;
	}
	
	public User CreateUser(User newUser) {
		return userRepository.save(newUser);
	}
	
}
