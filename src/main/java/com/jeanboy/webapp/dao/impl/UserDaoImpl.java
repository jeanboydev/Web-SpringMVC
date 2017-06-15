package com.jeanboy.webapp.dao.impl;

import com.jeanboy.webapp.dao.UserDao;
import com.jeanboy.webapp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Next on 2016/11/17.
 */
@Transactional
@Repository//标注数据访问组件，即DAO组件
public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();//取到当前管理的session
        session.persist(user);//持久化
        /**
         * session.save();
         * session.saveOrUpdate();
         */
        System.out.println("=====userDao==save==" + user.getId());
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    @Override
    public User getById(int id) {
        System.out.println("=====userDao==getById==");
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void update(User user, int id) {
        sessionFactory.getCurrentSession().merge(user);//把游离对象同步到数据库
        System.out.println("=====userDao==update==");
    }

    @Override
    public void deleteById(int id) {
        sessionFactory.getCurrentSession().delete(
                sessionFactory.getCurrentSession().load(User.class, id));
        System.out.println("=====userDao==deleteById==");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> from = query.from(User.class);
        query.select(from);
//        query.orderBy(builder.asc(from.get("age")));
        return session.createQuery(query).getResultList();
    }
}
