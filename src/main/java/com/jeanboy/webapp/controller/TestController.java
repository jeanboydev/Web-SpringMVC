package com.jeanboy.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Next on 2016/11/17.
 */
@Controller//标注控制层组件
@RequestMapping("/test")
public class TestController {

    /**
     *http://localhost:8080/test
     * @param model
     * @return
     */
    //默认执行该方法
    @RequestMapping(method = RequestMethod.GET)
    public String getTitle(Model model) {
        model.addAttribute("title", "测试title");
        model.addAttribute("desc", "Hello Spring MVC!");
        return "index";
    }
}
