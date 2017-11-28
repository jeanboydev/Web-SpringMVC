package com.jeanboy.webapp.domain.service;

import com.jeanboy.webapp.domain.UserContract;
import com.jeanboy.webapp.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserContract.Service{

    private final UserContract.Dao dao;

    @Autowired
    public UserService(UserContract.Dao dao) {
        this.dao = dao;
    }

    @Override
    public UserBean load(Long id) {
        return dao.load(id);
    }

    @Override
    public UserBean get(Long id) {
        return dao.get(id);
    }

    @Override
    public List<UserBean> findAll() {
        return dao.findAll();
    }

    @Override
    public void persist(UserBean entity) {
        dao.persist(entity);
    }

    @Override
    public Long save(UserBean entity) {
        return dao.save(entity);
    }

    @Override
    public void saveOrUpdate(UserBean entity) {
        dao.saveOrUpdate(entity);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void flush() {
        dao.flush();
    }
}
