package com.mywebapp.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywebapp.demo.model.User;
import com.mywebapp.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public User getUserById(int id) {
		return userRepo.findById(id).orElse(new User());
	}
	
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	public void addUser(User user) {
		userRepo.save(user);
	}
	
	public boolean removeUser(User user) {
		boolean isDeleted = false;
		try {
			if(userRepo.existsById(user.getUserid())) {
				userRepo.delete(user);
				isDeleted = true;
			} 
			
		} catch(Exception e) {
			e.getStackTrace();
		}
		
		return isDeleted;
	}

}
