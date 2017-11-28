package com.jeanboy.webapp.controller;

import com.alibaba.fastjson.JSON;
import com.jeanboy.webapp.domain.service.UserService;
import com.jeanboy.webapp.entity.User;
import com.jeanboy.webapp.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Next on 2017/6/15.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * http://localhost:8080/user/x
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getUserById(@PathVariable("id") Long id) {
        if (id != null) {
            UserBean user = userService.load(id);
            return JSON.toJSONString(user);
        }
        return "id != null";
    }

    /**
     * http://localhost:8080/user?username=hahahaha&password=newuserhaha
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String saveUser(@RequestParam(value = "username") String username,
                           @RequestParam(value = "password") String password) {
        UserBean user = new UserBean();
        user.setUsername(username);
        user.setPassword(password);
        userService.save(user);
        return "保存成功";
    }
}
