package com.jeanboy.webapp.service;

import com.jeanboy.webapp.entity.User;

/**
 * Created by Next on 2016/11/17.
 */
public interface UserService {

    void save(User user);

    User getById(int id);

    void update(User user,int id);

    String getUserName();

    void deleteById(int id);
}
