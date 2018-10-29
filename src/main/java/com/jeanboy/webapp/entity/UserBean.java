//package com.jeanboy.webapp.entity;
//
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Table(name = "User")
//public class UserBean implements Serializable{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private long id;
//    @Column(length = 20, nullable = false)
//    private String username;
//    @Column(length = 20, nullable = false)
//    private String password;
//    private int age;
//    private String address;
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//}
