package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.User;

public interface UserService {
	
	User saveUser(User user);
	Boolean checkUsernamePassword(String username, String password);
	Boolean checkUserByUsername(String username);
	Boolean checkAdmin(String username, String password);
	User getUserByUsername(String username);
	void setUsername(String username);
	String getUsername();
}
