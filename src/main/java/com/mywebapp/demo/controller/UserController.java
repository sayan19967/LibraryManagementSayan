package com.mywebapp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mywebapp.demo.model.User;
import com.mywebapp.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping(path="/user/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return service.getUserById(id);
	}
	
	@GetMapping(path="/user")
	public List<User> getUsers() {
		return service.getUsers();
	}
	
	@PostMapping(path="/user")
	public User addUser(@RequestBody User user) {
		service.addUser(user);
		return user;
	}
	
	@DeleteMapping(path="/user/{id}")
	public void removeUser(@PathVariable("id") int id) {
		User user = service.getUserById(id);
		boolean status = service.removeUser(user);
		if(status) {
			System.out.println("User deleted");
		} else {
			System.out.println("User not found");
		}
		//return obj;
		
	}

}
