package com.jeanboy.webapp.service.impl;

import com.jeanboy.webapp.dao.UserDao;
import com.jeanboy.webapp.entity.User;
import com.jeanboy.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Next on 2016/11/17.
 */
//@Transactional
@Service//用于标注业务层组件
public class UserServiceImpl implements UserService {


    //@Qualifier("userDao")
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {

        System.out.println("=UserService==save====");
        userDao.save(user);
    }

//    @Transactional(propagation = Propagation.NOT_SUPPORTED)//不开启事务
    @Override
    public User getById(int id) {
        System.out.println("=UserService==getById====");
//        throw  new RuntimeException("我的异常");
        return userDao.getById(id);
    }
//    @Transactional(propagation = Propagation.REQUIRED)//默认事务行为
    @Override
    public void update(User user, int id) {
        System.out.println("=UserService==update====");
        userDao.update(user,id);
    }

//    @Transactional(propagation = Propagation.REQUIRES_NEW)//开启新事务，现有事务挂起，该事务执行完，继续执行挂起事务
    @Override
    public String getUserName() {
        System.out.println("=UserService==getUserName====");
        return "getUserName==result";
    }

//    @Transactional(rollbackFor = Exception.class)//指定异常类型
    @Override
    public void deleteById(int id) {
        System.out.println("=UserService==deleteById====");
        userDao.deleteById(id);
    }
}
