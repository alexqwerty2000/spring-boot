package com.danit.springboot.entity;
import com.danit.springboot.validation.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts;

    @ManyToMany
    @JoinTable(name = "subscribers",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subscriber_user_id"))
    private List<User> subscribersOf;

    @ManyToMany(mappedBy = "subscribersOf", cascade = CascadeType.DETACH)
    private List<User> subscribersTo;
}



//import com.danit.springboot.validation.ValidPassword;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.List;
//
//import javax.persistence.*;
//import javax.validation.constraints.*;
//
//@Entity
//@Table(name = "users")
//@Getter
//@Setter
//public class User extends SystemUser {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
//    @Column(name = "user_id")
//    private Long userId;
//
//    @Column(name = "name")
//   // @ValidPassword(message= " sadfdasgadf")
//    @ValidPassword
//    private String name;
//
////    @Future
////    @Past
////    private Date date;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Post> posts;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name= "subscribers",
//            joinColumns = @JoinColumn(name="user_id", nullable = true),
//            inverseJoinColumns = @JoinColumn(name="subscriber_user_id"))
//    private List<User> sibscribersOf;
//
//    @ManyToMany(mappedBy="suscribersOf", cascade = CascadeType.DETACH)
//    private List<User> subscribersTo;

//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(List<Post> posts) {
//        this.posts = posts;
//    }
//}
