package com.jeanboy.webapp.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

/**
 * Created by Next on 2016/11/16.
 */
public class UnitSpringTestBase {
//    private ClassPathXmlApplicationContext context;
//    private String[] springXmlPath;
//
//    public UnitSpringTestBase() {
//    }
//
//    public UnitSpringTestBase(String... springXmlPath) {
//        this.springXmlPath = springXmlPath;
//    }
//
//    @Before
//    public void before() {
//        if (StringUtils.isEmpty(springXmlPath)) {
//            springXmlPath[0] = "classpath*:/config/spring-*.xml";
//        }
//        try {
//            context = new ClassPathXmlApplicationContext(springXmlPath);
//            context.start();
//        } catch (BeansException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @After
//    public void after() {
//        if (context != null) {
//            context.destroy();
//        }
//    }
//
//    protected <T extends Object> T getBean(String beanId) {
//        return (T) context.getBean(beanId);
//    }
//
//    protected <T extends Object> T getBean(Class<T> clazz) {
//        return (T) context.getBean(clazz);
//    }
}
