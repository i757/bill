package com.paopao.bill.service;

import com.paopao.bill.bean.User;
import com.paopao.bill.dao.UserRepository;
import com.paopao.bill.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luoxiaozhu
 * @date 2018-3-1-0001 13:41
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User findOne(String id){
        return userRepository.findOne(id);
    }

    public User getUser(String id){
        return userRepository.getUser(id);
    }

    public User findByName(String name){
        return userRepository.findByName(name);
    }

    public User selectUser(String account, String name){
        return userMapper.selectUser(account, name);
    }
}
