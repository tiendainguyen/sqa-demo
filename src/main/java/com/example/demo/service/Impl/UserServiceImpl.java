package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entity.*;
import com.example.demo.repository.UserRoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ComputerRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ComputerService;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private final UserRoleRepository userRoleRepository;
	@Autowired
	private UserRepository userRepository;
	private String username;
    @Autowired
    private PasswordEncoder passwordEncoder;


	public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository) {
		super();
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
	}


	@Override
	@Transactional
	public User saveUser(User user) {
		try {
			if(userRepository.existsByUsername(user.getUsername())) {
				throw new RuntimeException();
			}
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user = userRepository.save(user);
			// TODO Auto-generated method stub
			UserRole userRole = new UserRole();
			userRole.setRoleId(1);
			userRole.setUserId(user.getID());
			userRoleRepository.save(userRole);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<UserRoleProjection> users = userRepository.findUserProjectionByUsername(username);
		if (users != null) {
			UserRoleProjection user = users.get(0);
			List<Role> roles = new ArrayList<>();
			users.forEach(u -> roles.add(new Role(u.getRoleId(), u.getRoleName())));
			return new org.springframework.security.core.userdetails.User(user.getUsername(),
					user.getPassword(),
					mapRolesToAuthorities(roles));
		}else{
			throw new UsernameNotFoundException("Invalid username or password.");
		}
	}

	private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
		Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName()))
				.collect(Collectors.toList());
		return mapRoles;
	}
}