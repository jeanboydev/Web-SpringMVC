package com.jeanboy.webapp.service;

import com.jeanboy.webapp.dao.UserDao;
import com.jeanboy.webapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Next on 2016/11/17.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getAllUserNames() {
        return userDao.findAll();
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }
}
