package com.in.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.blogs.binding.Createpost;
import com.in.blogs.service.PostService;
import com.in.blogs.utility.ApplicationConstains;
import com.in.blogs.utility.UserException;

@RestController
@RequestMapping("/post")
public class PostController {
    
	@Autowired
	private PostService  postService;
	
	@PostMapping("/new")
	public ResponseEntity<String> newPost(@RequestBody Createpost createpost)throws UserException{
	
	ResponseEntity<String>  responce =null;
	if(createpost.getTitle().trim().isEmpty()||createpost.getDescription().trim().isEmpty() 
	  ||createpost.getDescription().trim().isEmpty()){
		
	  responce = new  ResponseEntity<String>(ApplicationConstains.ENTER_ALL_DETAILS,HttpStatus.BAD_REQUEST);
	}else{
	  String status=postService.createNewPost(createpost);
	  responce = new ResponseEntity<String>(status,HttpStatus.OK);
	}	
      return responce;
	}
	
}
