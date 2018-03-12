package com.paopao.bill.dao;

import com.paopao.bill.bean.InOut;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 罗高杨 on 2018-3-4.
 */
public interface InOutRepository extends JpaRepository<InOut,String> {
}
