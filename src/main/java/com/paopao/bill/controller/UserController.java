package com.paopao.bill.controller;

import com.paopao.bill.UserService;
import com.paopao.bill.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author luoxiaozhu
 * @date 2018-3-1-0001 14:17
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findOne")
    @ResponseBody
    public User findOne(@RequestParam String id){
        User user = userService.findOne(id);
        return user;
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(@RequestParam String id){
        return userService.getUser(id);
    }

    @RequestMapping("/findByName")
    @ResponseBody
    public User findByName(@RequestParam String name){
        return userService.findByName(name);
    }

    @RequestMapping("/selectUser")
    @ResponseBody
    public User selectUser(@RequestParam String account, @RequestParam String name){
        return userService.selectUser(account, name);
    }

}
