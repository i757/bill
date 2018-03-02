package com.paopao.bill.dao;

import com.paopao.bill.bean.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,String> {

}
