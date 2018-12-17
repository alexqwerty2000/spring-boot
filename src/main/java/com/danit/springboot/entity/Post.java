package com.danit.springboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "post_message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "post_user_id")
    private User user;

//    public Long getPostId() {
//        return postId;
//    }
//
//    public void setPostId(Long postId) {
//        this.postId = postId;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}

