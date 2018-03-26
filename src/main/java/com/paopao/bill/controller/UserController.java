package com.paopao.bill.controller;

import com.paopao.bill.bean.pojo.UserLogin;
import com.paopao.bill.service.UserService;
import com.paopao.bill.bean.User;
import com.paopao.bill.util.ApiException;
import com.paopao.bill.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author luoxiaozhu
 * @date 2018-3-1-0001 14:17
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public User login(@RequestBody UserLogin bean){
        User user = userService.findByAccountAndPassword(bean.getAccount(),bean.getPassword());
        if(user == null){
            throw new ApiException(Constants.USER_NOT_EXIST);
        }
        user.setPassword("");
        return user;
    }

}
