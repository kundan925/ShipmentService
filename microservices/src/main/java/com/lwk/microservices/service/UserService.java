package com.lwk.microservices.service;

import com.lwk.microservices.dto.UserDTO;
import com.lwk.microservices.entity.User;

public interface UserService {
	User saveUser(UserDTO user);
	
}
