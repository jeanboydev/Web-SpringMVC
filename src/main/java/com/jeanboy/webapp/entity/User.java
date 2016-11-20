package com.jeanboy.webapp.entity;

import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.io.Serializable;

import static org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE;

/**
 * Created by Next on 2016/11/17.
 */
@Entity
@Cache(usage = READ_WRITE,region = "com.jeanboy.webapp.entity.User")
@Table
public class User implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private int age;
    private String address;

    public User() {
    }

    public User(String username, String password, int age, String address) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(length = 20,nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
