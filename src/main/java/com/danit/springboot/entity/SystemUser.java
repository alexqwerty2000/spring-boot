package com.danit.springboot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@Data
//@Entity при добавлени ничего не змениться
@MappedSuperclass
public class SystemUser {
    @Column(name="user_email")
    private String email;

    @Column(name="user_password")
    private String password;
}
