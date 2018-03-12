package com.paopao.bill.dao;

import com.paopao.bill.bean.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BillRepository extends JpaRepository<Bill,String> {
  Bill findById(String id);

  @Modifying
  @Transactional(rollbackFor = Exception.class)
  @Query(value = "update bill set flag = 1,flagTime = ?2 where time like concat(?1,'%')",nativeQuery = true)
  void updateStatusByTime(String time,String statusTime);

}
