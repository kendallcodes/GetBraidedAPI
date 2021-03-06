package com.getbraided.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.getbraided.entity.User;
import com.getbraided.service.UserService;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service; 
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Object> register(@RequestBody User user) { 
		return new ResponseEntity<Object>(service.createUser(user), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Object> login(@RequestBody User user) { 
		try { 
			return new ResponseEntity<Object>(service.login(user), HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST); 
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getAllUsers(){
		return new ResponseEntity<Object>(service.getAllUsers(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
		public ResponseEntity<Object> deleteUser(@PathVariable Long userId) {
				service.deleteUser(userId);
		return new ResponseEntity<Object>("Delete user id" + userId, HttpStatus.OK);
		}
	}

