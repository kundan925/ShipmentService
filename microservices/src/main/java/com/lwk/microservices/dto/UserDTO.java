package com.lwk.microservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	@NotNull
	private String name;
	
	@Email
	private String email;
	
	@NotBlank
	private String password;
	
	private String role;

}
