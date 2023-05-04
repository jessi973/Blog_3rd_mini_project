package com.in.blogs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.blogs.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
