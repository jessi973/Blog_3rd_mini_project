package com.in.blogs.serviceimpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.in.blogs.binding.UserLogin;
import com.in.blogs.binding.UserRegistration;
import com.in.blogs.entity.User;
import com.in.blogs.repo.UserRepository;
import com.in.blogs.service.Userservice;
import com.in.blogs.utility.ApplicationConstains;
import com.in.blogs.utility.UserException;


@Service
public class UserServiceImpl implements Userservice{

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public String userRegistration(UserRegistration registration)throws UserException {
      
		User user = new User();
		BeanUtils.copyProperties(registration, user);
		repository.save(user);
		return ApplicationConstains.SUCESS;
	}

	@Override
	public String login(UserLogin login) throws UserException {
	
    	User user=repository.findByEmaiId(login.getEmaiId());
    	if(user==null) {
    	  throw new UserException(ApplicationConstains.INVALID_EMAIL,HttpStatus.NOT_FOUND);	
    	} 
    	if(user.getEmaiId().equals(login.getEmaiId())&& user.getPassword().equals(login.getPassword())){
    		httpSession.setAttribute(ApplicationConstains.USER_ID, user.getUserId());
 
    	  return ApplicationConstains.SUCESS;	
    	  
    	}else {
    		throw new UserException(ApplicationConstains.INVALID_EMAIL,HttpStatus.BAD_REQUEST);	
    	}
	}

}
