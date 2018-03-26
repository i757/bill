package com.paopao.bill.dao.mapper;

import com.paopao.bill.bean.pojo.InOutBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 罗高杨 on 2018-3-4.
 */
@Component
@Mapper
public interface InOutMapper {
    @Select("select a.outMoney,a.inMoney,b.`name` from inoutmoney a left join `user` b on a.userId = b.id " +
            "where resultId = #{resultId}")
    List<InOutBean> getInOuts(String resultId);
}
