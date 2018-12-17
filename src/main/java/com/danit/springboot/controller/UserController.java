package com.danit.springboot.controller;

import com.danit.springboot.dto.UserDto;
import com.danit.springboot.service.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String addUserForm(ModelMap model) {
        model.put("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/users/{id}")
    public String addUserForm(ModelMap model, @PathVariable("id") Long userId) {
        model.put("user", userService.getUserById(userId));
        return "user";
    }

    @PostMapping("/users/{id}/delete")
    @Transactional
    public String deleteUserForm(ModelMap model, @PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
        model.put("user", userService.getAllUsers());
        return "redirect:/users";
    }

    @PostMapping(value = "/users/add?json")
    public String addUser(@ModelAttribute @Valid UserDto userDto) {
//        userDto.builder().name("UserName").email("user@remail.com").build();
        userService.addUser(userDto);
        return "redirect:/users";
    }

    @GetMapping("/api/v2/users")
    @ResponseBody
    public List<UserDto> allUsersJson(){
        return userService.getAllUsersMap();
    }

    @GetMapping("/api/v2/users/string")
    @ResponseBody
    public String allUsersJsonString() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("dd-mmm-yyy"));
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userService.getAllUsersMap());
    }
}

