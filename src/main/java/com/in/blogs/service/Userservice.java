package com.in.blogs.service;

import com.in.blogs.binding.UserLogin;
import com.in.blogs.binding.UserRegistration;
import com.in.blogs.utility.UserException;

public interface Userservice {
	
public String userRegistration(UserRegistration registration)throws UserException;
	
public String login(UserLogin login)throws UserException;

}
