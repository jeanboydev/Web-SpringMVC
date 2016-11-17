package com.jeanboy.webapp.dao;

import com.jeanboy.webapp.entity.User;

import java.util.List;

/**
 * Created by Next on 2016/11/17.
 */
public interface UserDao {
    int save(User u);

    List<User> findAll();
}
