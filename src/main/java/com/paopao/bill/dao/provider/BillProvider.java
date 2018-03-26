package com.paopao.bill.dao.provider;

import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * @author luoxiaozhu
 * @date 2018-3-2-0002 14:27
 */
public class BillProvider {
    public static String billList(Map<String,String> map){
        StringBuilder sql = new StringBuilder();
        sql.append("select b.id,money,time,flag,name userName from bill b left join user u on b.userId = u.id");
        if(StringUtils.isNotBlank(map.get("time"))){
            sql.append(" where time like concat(#{time},'%')");
        }
        sql.append(" order by submitTime asc");
        return sql.toString();
    }
}
