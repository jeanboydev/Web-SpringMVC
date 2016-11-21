package com.jeanboy.webapp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Next on 2016/11/17.
 */
@Entity
//@Cache(usage = READ_WRITE,region = "com.jeanboy.webapp.entity.User")
@Table//表的信息描述
public class User implements Serializable {

    /**
     * 一对一单向外键关联@OneToOne
     * 一对一双向外键关联@OneToOne(mappedBy="")//被控方
     * 多对一单向外键关联（多个学生持有一个班级）
     * 一对多单向外键关联（一个班级多个学生）
     * 多对多单向外键关联
     * 多对多双向外键关联
     */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(length = 20, nullable = false)
    private String username;
    private String password;
    private int age;
    private String address;
    //一对一单向
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uid", unique = true)
    private UserInfo userInfo;
    //多对一单向
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)//EAGER积极加载
    @JoinColumn(name = "cid", referencedColumnName = "ID")
    private ClassRoom classRoom;

    //多对多单向
    @ManyToMany
    @JoinTable(name = "teacher_user",
            joinColumns = {@JoinColumn(name = "sid")},
            inverseJoinColumns = {@JoinColumn(name = "tid")})
    private List<Teacher> teachers;

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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
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
