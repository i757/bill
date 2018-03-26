package com.paopao.bill.dao.mapper;

import com.paopao.bill.bean.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 罗高杨 on 2018-3-4.
 */

@Component
@Mapper
public interface ResultMapper {

    @Select("select * from result order by resultTime desc")
    List<Result> getResult();

}
