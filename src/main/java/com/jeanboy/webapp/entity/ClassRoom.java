//package com.jeanboy.webapp.entity;
//
//import javax.persistence.*;
//import java.util.List;
//
///**
// * Created by Next on 2016/11/21.
// */
//@Entity
//public class ClassRoom {
//
//    @Id
//    @GeneratedValue
//    private int id;
//    private String name;
//    //一对多双向
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "id")
//    private List<User> users;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
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
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//}
