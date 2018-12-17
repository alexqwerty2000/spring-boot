package com.danit.springboot.repository;

import com.danit.springboot.entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}

