package com.danit.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="persons")
@Data
public class Person extends SystemUser{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="person_id")
    private Long personId;

    @Column(name="password")
    private String password;
}
