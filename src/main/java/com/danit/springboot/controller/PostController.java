package com.danit.springboot.controller;

import com.danit.springboot.dto.PostDto;
import com.danit.springboot.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping(value = "/posts/add")
    public String addUser(@ModelAttribute PostDto postDto) {
        postService.addPost(postDto);
        return "redirect:/users/" + postDto.getUserId();
    }
}

