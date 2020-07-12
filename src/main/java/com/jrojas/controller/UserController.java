package com.jrojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jrojas.model.User;
import com.jrojas.service.UserService;
import com.jrojas.util.Validator;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Validator validator;

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		
		if(validator.comprobeUser(user)) {
			return ResponseEntity.ok(this.userService.saveUser(user));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> findAll() {
				
		return ResponseEntity.ok(this.userService.findAll());
	}
	
	@GetMapping
	public ResponseEntity<User> findByUserName(@RequestParam("user_name") String username) {
		
		if(this.validator.comprobeUsername(username)) {
			return ResponseEntity.ok(this.userService.findByUsername(username));
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
	}
	
}
