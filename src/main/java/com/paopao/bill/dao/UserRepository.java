package com.paopao.bill.dao;

import com.paopao.bill.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author luoxiaozhu
 * @date 2018-3-1-0001 13:39
 */
public interface UserRepository extends JpaRepository<User,String> {

    @Query(value = "select DISTINCT id from user",nativeQuery = true)
    List<String> getUsers();

    User findByAccountAndPassword(String account, String password);
}
