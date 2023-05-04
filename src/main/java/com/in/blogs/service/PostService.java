package com.in.blogs.service;

import java.util.List;

import com.in.blogs.binding.Createpost;
import com.in.blogs.entity.Post;
import com.in.blogs.utility.UserException;

public interface PostService {
	
	public String createNewPost(Createpost creatpost)throws UserException;

	public List<Createpost> getAllPost()throws UserException;
}
