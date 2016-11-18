package com.jeanboy.webapp.dao;

import com.jeanboy.webapp.entity.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Next on 2016/11/17.
 */
@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public int save(User u) {
        return (Integer) sessionFactory.getCurrentSession().save(u);
    }

    public List<User> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        return criteria.list();
    }

    @Override
    public User getById(int id) {
        return getHibernateTemplate().get(User.class, id);
    }
}
