package com.in.blogs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.blogs.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByEmaiId(String emaild);

}
