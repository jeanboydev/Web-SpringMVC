package com.jeanboy.webapp.dao.impl;

import com.jeanboy.webapp.entity.User;
import com.jeanboy.webapp.service.UserService;
import com.jeanboy.webapp.test.UnitSpringTestBase;
import org.junit.Test;

/**
 * Created by next on 2016/11/20.
 */
public class UserDaoImplTest extends UnitSpringTestBase {

    private UserService userService;

    public UserDaoImplTest() {
        super("classpath*:/config/spring-core.xml", "classpath*:/config/spring-hibernate.xml");
    }


    @Test
    public void save() throws Exception {
        userService = super.getBean("userServiceImpl");
        userService.save(new User("test2", "testpass2", 18, "北京昌平区"));
    }

    @Test
    public void getById() throws Exception {
        userService = super.getBean("userServiceImpl");
        User user = userService.getById(1);
        System.out.println(user.toString());
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void deleteById() throws Exception {

    }

    @Test
    public void getUsers() throws Exception {

    }

}