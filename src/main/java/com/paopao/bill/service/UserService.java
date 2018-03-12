package com.paopao.bill.service;

import com.paopao.bill.bean.User;
import com.paopao.bill.dao.UserRepository;
import com.paopao.bill.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luoxiaozhu
 * @date 2018-3-1-0001 13:41
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<String> getUsers() {
        return userRepository.getUsers();
    }

    public User findByAccountAndPassword(String account, String password) {
        return userRepository.findByAccountAndPassword(account,password);
    }
}
