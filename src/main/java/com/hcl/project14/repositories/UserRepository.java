package com.hcl.project14.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hcl.project14.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByName(String name);
}