package com.lwk.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwk.microservices.config.JwtUtil;
import com.lwk.microservices.dto.RequestDTO;
import com.lwk.microservices.dto.ResponseDTO;
import com.lwk.microservices.dto.UserDTO;
import com.lwk.microservices.entity.User;
import com.lwk.microservices.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/userDetails")
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;
	
    //creating new user
	@PostMapping(value = "/user")
	public ResponseEntity<User> saveUser(@Valid @RequestBody UserDTO user){
		User responseUser = userServiceImpl.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
	}
	
	//user login
	@PostMapping(value = "/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody RequestDTO user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUserName(),
                        user.getUserPassword()
                )
        );
        String token = jwtUtil.generateToken(user.getUserName());
        ResponseDTO response = new ResponseDTO();
        response.setToken(token);
        response.setStatus(200);
        return ResponseEntity.ok(response);
    }
	

}
