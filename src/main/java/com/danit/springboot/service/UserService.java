package com.danit.springboot.service;

import com.danit.springboot.dto.UserDto;
import com.danit.springboot.entity.User;
import com.danit.springboot.repository.PostRepository;
import com.danit.springboot.repository.UserDAO;
import com.danit.springboot.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    private UserDAO userDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UserDto> getAllUsers() {
        List<UserDto> usersDto = new ArrayList<>();
        for(User user: userRepository.findAll()){
            UserDto dto = new UserDto();
            dto.setUserId(user.getUserId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            usersDto.add(dto);
        }
        if(true){
            throw new RuntimeException("FATAl ERROR");
        }
        return usersDto;
    }

    public List<UserDto> getAllUsersMap(){
        ModelMapper modelMapper = new ModelMapper();
        List<UserDto> usersDto = new ArrayList<>();
        for(User user: userRepository.findAll()){
            usersDto.add(modelMapper.map(user, UserDto.class));
        }
        return usersDto;
    }

    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public User addUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        return userRepository.save(user);
    }
}
