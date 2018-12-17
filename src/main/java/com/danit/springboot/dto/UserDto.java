package com.danit.springboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
//@Builder
@NoArgsConstructor
public class UserDto {

//    @JsonIgnore
    private Long userId;

    private String name;

    @NotEmpty
    @Email
    private String email;


//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}

