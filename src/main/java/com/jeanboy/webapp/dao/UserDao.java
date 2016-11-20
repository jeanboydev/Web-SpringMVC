package com.jeanboy.webapp.dao;

import com.jeanboy.webapp.entity.User;

import java.util.List;

/**
 * Created by Next on 2016/11/17.
 */
public interface UserDao {

    void save(User user);

    User getById(int id);

    void update(User user,int id);

    void deleteById(int id);

    List<User> getUsers();
}
