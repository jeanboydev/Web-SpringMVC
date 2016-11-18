package com.jeanboy.webapp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by Next on 2016/11/16.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class SpringTest extends UnitSpringTestBase {

    public SpringTest() {
        super("classpath*:spring-bean.xml");
    }

    @Test
    public void instanceSpring() {
//        TestBean test = super.getBean("testBean");
//        test.save();
        System.out.println("=======");
    }
}
