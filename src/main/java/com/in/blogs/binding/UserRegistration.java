package com.in.blogs.binding;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserRegistration {
	
	private String firstName;
	private String lastName;
	@NotEmpty
	@Email
	private String emaiId;
	private String password;

}
