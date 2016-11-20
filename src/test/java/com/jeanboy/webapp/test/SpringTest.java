package com.jeanboy.webapp.test;

import com.jeanboy.webapp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by Next on 2016/11/16.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class SpringTest extends UnitSpringTestBase{

    public SpringTest() {
        super("classpath*:/config/spring-beans.xml");
    }

    @Test
    public void instanceSpring() {
        UserService userService = super.getBean("userServiceImpl");
        userService.getById(0);
        System.out.println("=======");
    }

    @Test
    public void aopTest(){
        UserService userService = super.getBean("userServiceImpl");
        userService.getById(0);
        userService.getUserName();
    }
}
