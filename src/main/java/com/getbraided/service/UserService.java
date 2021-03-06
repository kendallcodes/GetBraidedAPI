package com.getbraided.service;

import com.getbraided.entity.Stylist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getbraided.entity.User;
import com.getbraided.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public Iterable<User> getAllUsers() {
		return repo.findAll();
	}

		public User createUser(User user) {
		return repo.save(user); 
	}
	
	public User login(User user) throws Exception { 
		User foundUser = repo.findByUsername(user.getUsername()); 
		if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
			return foundUser;
		} else { 
			throw new Exception("Sorry! Username or password is invalid."); 
		}
	}


	public void deleteUser(Long userId) {
		repo.delete(userId);

	}

	
	
}
