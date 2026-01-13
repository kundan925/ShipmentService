package com.lwk.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lwk.microservices.dto.UserDTO;
import com.lwk.microservices.entity.User;
import com.lwk.microservices.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	public User saveUser(UserDTO user) {
		User newUser = new User();
		newUser.setName(user.getName());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setEmail(user.getEmail());
		newUser.setRole(user.getRole());
		return userRepository.save(newUser);
	}
	

}
