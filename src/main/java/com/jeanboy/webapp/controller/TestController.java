package com.jeanboy.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.html.FormSubmitEvent;

/**
 * Created by Next on 2016/11/17.
 */
@Controller//标注控制层组件
@RequestMapping("/test")//http://localhost:8080/test
public class TestController {

    //默认执行该方法
    @RequestMapping(method = RequestMethod.GET)
    public String getTitle(Model model) {
        //响应参数
        model.addAttribute("title", "测试title");
        model.addAttribute("desc", "Hello Spring MVC!");
        return "index";//响应index.jsp
    }

    /**
     * http://localhost:8080/test/title
     *
     * @return
     */
    @RequestMapping(value = "/title", method = RequestMethod.GET)
    @ResponseBody//响应数据直接输出
    public String getTitle() {
        return "hahhahhahha";
    }

    /**
     * http://localhost:8080/test/user?username=aaa&password=bbb
     *
     * @return
     */
    @RequestMapping(value = "/user", params = {"username=aaa", "password=bbb"}, method = RequestMethod.GET)
    @ResponseBody//响应数据直接输出
    public String getUserParams() {
        return "getTitleParams";
    }

    /**
     * http://localhost:8080/test/user2?username=aaa&password=bbb
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/user2", method = {RequestMethod.GET, RequestMethod.HEAD})
    @ResponseBody//响应数据直接输出
    public String getUserParams(@RequestParam(value = "username") String username,
                                @RequestParam(value = "password") String password) {
        return "username=" + username + "==password=" + password;
    }

    /**
     * http://localhost:8080/test/user/1
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody//响应数据直接输出
    public String getByUserId(@PathVariable("id") Integer id) {
        return "user id=" + id;
    }

    //异常异常处理
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception ex) {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("exception", ex);
        System.out.println("in testExceptionHandler 拦截到错误");
        return mv;
    }

    /**
     * http://localhost:8080/test/error
     *
     * @return
     */
    @RequestMapping("/error")
    public String error() {
        int i = 5 / 0;
        return "index";
    }
}
