package com.danit.springboot.service;

import com.danit.springboot.dto.PostDto;
import com.danit.springboot.entity.Post;
import com.danit.springboot.repository.PostRepository;
import com.danit.springboot.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    public Post addPost(PostDto postDto) {
        Post post = new Post();
        post.setMessage(postDto.getMessage());
        post.setUser(userRepository.getOne(postDto.getUserId()));
        return postRepository.save(post);
    }
}

