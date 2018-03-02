package com.paopao.bill.dao.mapper;

import com.paopao.bill.bean.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BillMapper {

//    @Select("select * from bill where time like concat(#{time},'%')")
    @SelectProvider(type = BillProvider.class,method = "billList")
    List<Bill> billList(@Param("time") String time);

    @Select("select distinct time from bill order by time asc")
    List<String> getBillTime();
}
