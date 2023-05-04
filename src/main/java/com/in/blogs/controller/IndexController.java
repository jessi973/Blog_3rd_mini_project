package com.in.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.blogs.binding.Createpost;
import com.in.blogs.service.PostService;
import com.in.blogs.utility.UserException;

@RestController
public class IndexController {
	@Autowired
	private PostService postService;

	@GetMapping("/")
	public ResponseEntity<List<Createpost>> getAllPost() throws UserException{
		
		ResponseEntity<List<Createpost>> responce=null;
		List<Createpost> posts=	postService.getAllPost();
		if(posts.isEmpty()) {
			responce= new ResponseEntity<List<Createpost>>(posts,HttpStatus.NOT_FOUND);
		}else {
			responce= new ResponseEntity<List<Createpost>>(posts,HttpStatus.OK);

		}
		
		return responce;
	}
}
