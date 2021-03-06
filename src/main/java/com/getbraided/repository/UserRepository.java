package com.getbraided.repository;

import org.springframework.data.repository.CrudRepository;

import com.getbraided.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public User findByUsername(String username);

}
