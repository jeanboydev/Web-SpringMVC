package com.jeanboy.webapp.service;

import com.jeanboy.webapp.entity.User;

import java.util.List;

/**
 * Created by Next on 2016/11/17.
 */
public interface UserService {

    public void saveUsers(List<User> us);

    public List<User> getAllUserNames();
}
