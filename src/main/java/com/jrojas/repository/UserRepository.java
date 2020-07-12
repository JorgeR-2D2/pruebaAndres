package com.jrojas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrojas.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserNameAndPassword(String userName, String password);
	
	public User findByUserName(String userName);
	
	public User findByPassword(String password);
}
