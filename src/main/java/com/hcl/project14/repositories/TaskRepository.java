package com.hcl.project14.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hcl.project14.entities.User;
import com.hcl.project14.entities.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

	public Task findByName(String name);
	
	public List<Task> findAllByUser(User user);
}
