package com.lwk.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lwk.microservices.config.UserInfoUserDetails;
import com.lwk.microservices.entity.User;
import com.lwk.microservices.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    

    @Override
    public UserDetails loadUserByUsername(String name)
            throws UsernameNotFoundException {

        User user = userRepository.findByName(name)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));
        

        return new UserInfoUserDetails(user);
    }
}
