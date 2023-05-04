package com.in.blogs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.blogs.entity.Comment;

public interface CommenetRepository extends JpaRepository<Comment, Integer> {

}
