package com.jeanboy.webapp.domain.repository;

import com.jeanboy.webapp.domain.UserContract;
import com.jeanboy.webapp.entity.User;
import com.jeanboy.webapp.entity.UserBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional//事务注解
@Repository
public class UserRepository implements UserContract.Dao {

    @Resource
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    //    @Transactional(propagation = Propagation.NOT_SUPPORTED)//不开启事务
    @Override
    public UserBean load(Long id) {
        return getCurrentSession().load(UserBean.class, id);
    }

    //    @Transactional(propagation = Propagation.REQUIRES_NEW)//开启新事务，现有事务挂起，该事务执行完，继续执行挂起事务
    @Override
    public UserBean get(Long id) {
        return getCurrentSession().get(UserBean.class, id);
    }

    //    @Transactional(rollbackFor = Exception.class)//指定异常类型，异常回滚
    @Override
    public List<UserBean> findAll() {
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserBean> query = builder.createQuery(UserBean.class);
        Root<UserBean> from = query.from(UserBean.class);
        query.select(from);
//        query.orderBy(builder.asc(from.get("age")));
        return session.createQuery(query).getResultList();
    }

    @Override
    public void persist(UserBean entity) {
        getCurrentSession().persist(entity);//持久化
    }

    @Override
    public Long save(UserBean entity) {
        return (Long) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(UserBean entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Long id) {
        UserBean userBean = load(id);
        getCurrentSession().delete(userBean);
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }
}
