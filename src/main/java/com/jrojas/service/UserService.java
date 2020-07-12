package com.jrojas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrojas.model.User;
import com.jrojas.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
				
	public User saveUser(User user) {
		return this.userRepository.save(user);
	}
	
	public List<User> findAll() {
		List<User> userList = this.userRepository.findAll();
		
		return userList;	
	}
	
	public User findByUsername(String userName) {
		return this.userRepository.findByUserName(userName);
	}
	
}
