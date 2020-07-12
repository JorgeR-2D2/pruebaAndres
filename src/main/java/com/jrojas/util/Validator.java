package com.jrojas.util;

import org.springframework.stereotype.Component;

import com.jrojas.model.User;

@Component
public class Validator {

	public boolean comprobeUser(User user) {
		if(user.getUserName() == null || user.getUserName().length() > 10) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean comprobeUsername(String username) {
		return username.length() <= 10 ? true: false;
	}
}
