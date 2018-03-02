package com.paopao.bill.dao.mapper;

import com.paopao.bill.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    @Select("select * from user where account = #{account} and name = #{name}")
    User selectUser(@Param("account") String account, @Param("name") String name);
}
