package com.lwk.microservices.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lwk.microservices.entity.User;

public class UserInfoUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private final User user;
	
	public UserInfoUserDetails(User user) {
		this.user=user;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
    }

	@Override
    public String getPassword() {
        return user.getPassword();
    }

	@Override
    public String getUsername() {
        return user.getName();
    }
	
	@Override
	public boolean isAccountNonExpired() { 
		return true;
	}
	
    @Override
    public boolean isAccountNonLocked() { 
    	return true; 
    }
    
    @Override
    public boolean isCredentialsNonExpired() { 
    	return true; 
    }
    
    @Override
    public boolean isEnabled() { 
    	return true; 
    }

}
