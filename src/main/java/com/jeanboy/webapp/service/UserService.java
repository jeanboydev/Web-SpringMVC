package com.jeanboy.webapp.service;

import com.jeanboy.webapp.entity.User;

import java.util.List;

/**
 * Created by Next on 2016/11/17.
 */
public interface UserService {

    public void saveUser(User user);

    public List<User> getAllUserNames();


    User getById(int id);
}
