package com.in.blogs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.blogs.binding.UserLogin;
import com.in.blogs.binding.UserRegistration;
import com.in.blogs.service.Userservice;
import com.in.blogs.utility.ApplicationConstains;
import com.in.blogs.utility.UserException;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private Userservice userservice;
	
 @PostMapping("/registration")	
 public ResponseEntity<String> userRegistration(@Valid @RequestBody UserRegistration registration)throws UserException{
		
	 ResponseEntity<String> responce=null;
	 if(registration.getFirstName().trim().isEmpty() || registration.getLastName().trim().isEmpty()
		||registration.getEmaiId().trim().isEmpty() ||registration.getPassword().trim().isEmpty()) {
		 
		 responce= new ResponseEntity<String>(ApplicationConstains.ENTER_ALL_DETAILS,HttpStatus.BAD_REQUEST); 
	 }else {
	  String status=	 userservice.userRegistration(registration);
	  responce= new ResponseEntity<String>(status,HttpStatus.CREATED); 
	 }	
		return responce;
		}

 @PostMapping("/login")
  public ResponseEntity<String> userLogin(@RequestBody UserLogin login) throws UserException{
	String status= userservice.login(login);
	return  ResponseEntity.ok(status); 
 }

}
