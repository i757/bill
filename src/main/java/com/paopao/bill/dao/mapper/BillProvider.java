package com.paopao.bill.dao.mapper;

import org.apache.commons.lang.StringUtils;

/**
 * @author luoxiaozhu
 * @date 2018-3-2-0002 14:27
 */
public class BillProvider {
    public static String billList(String time){
        StringBuilder sql = new StringBuilder();
        sql.append("select * from bill");
        if(StringUtils.isNotBlank(time)){
            sql.append(" where time like concat(#{time},'%')");
        }
        sql.append(" order by submitTime asc");
        return sql.toString();
    }
}
