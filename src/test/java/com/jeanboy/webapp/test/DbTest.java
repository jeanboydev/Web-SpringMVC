package com.jeanboy.webapp.test;

import com.jeanboy.webapp.entity.User;
import com.jeanboy.webapp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Next on 2016/11/17.
 */
@RunWith(BlockJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:config/spring-core.xml", "classpath*:config/spring-hibernate.xml"})
@Transactional
public class DbTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("test1");
        user.setPassword("test1pass");
        user.setAge(18);
        user.setAddress("北京昌平区");
        userService.save(user);
    }
}
