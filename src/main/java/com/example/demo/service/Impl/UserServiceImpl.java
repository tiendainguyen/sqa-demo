package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Computer;
import com.example.demo.entity.User;
import com.example.demo.repository.ComputerRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ComputerService;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	private String username;


	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		user.setRole(0);
		return userRepository.save(user);
	}


	@Override
	public Boolean checkUsernamePassword(String username, String password) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		if (user.getPassword().equals(password))
			return true;
		return false;
	}


	@Override
	public Boolean checkUserByUsername(String username) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		if (user == null)
			return false;
		return true;
	}


	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.getUserByUsername(username);
	}


	@Override
	public Boolean checkAdmin(String username, String password) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		if (user.getPassword().equals(password) && user.getRole() ==1 )
			return true;
		return false;
	}


	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		this.username = username;
		
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}



}