package com.paopao.bill.dao;

import com.paopao.bill.bean.User;
//import com.paopao.bill.dao.mapper.UserMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author luoxiaozhu
 * @date 2018-3-1-0001 13:39
 */
public interface UserRepository extends JpaRepository<User,String>{
    @Query(value = "select * from user where id = ?1",nativeQuery = true)
    User getUser(String id);

    User findByName(String name);
}
