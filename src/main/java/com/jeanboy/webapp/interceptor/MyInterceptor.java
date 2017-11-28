package com.jeanboy.webapp.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by next on 2016/11/20.
 */
@Aspect//声明切面
public class MyInterceptor {

    /**
     * @Pointcut("execution(* com.jeanboy.webapp..*.*(..))")
     * execution执行
     * 第一个*表示任何返回类型
     * com.jeanboy.webapp包名
     * ..表示子包也拦截
     * 第二个*类
     * 第三个*类中的方法
     * 例如：*.*类中的所有方法
     * (..)表示方法中的参数任意
     */
    @Pointcut("execution(* com.jeanboy.webapp.service.impl.UserServiceImpl.*(..))")
    private void anyMethod(){}//声明一个切入点



    @Before("anyMethod() && args(name)")//只匹配参数为name的方法
    public void doAccessCheck(String name){
        System.out.println("前置通知");
    }

    @AfterReturning(value = "anyMethod()",returning = "result")//返回结果
    public void doAfterReturning(String result){
        System.out.println("后置通知："+result);
    }

    @AfterThrowing(value = "anyMethod()",throwing = "e")
    public void doAfterThrowing(Exception e){
        System.out.println("异常通知："+e.getMessage());
    }

    @After("anyMethod()")
    public void doAfter(){
        System.out.println("最终通知");
    }

    @Around("anyMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
//        if(){//判断是否有权限
            System.out.println("环绕通知进入");
            Object result=pjp.proceed();
            System.out.println("环绕通知退出");
//        }
        return result;
    }
}
