package com.paopao.bill.service;

import com.paopao.bill.bean.Bill;
import com.paopao.bill.dao.BillRepository;
import com.paopao.bill.dao.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author luoxiaozhu
 * @date 2018-3-2-0002 11:12
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private BillMapper billMapper;

    public void saveBill(Bill bill){
        billRepository.save(bill);
    }

    public Bill getBill(String id){
        return billRepository.getOne(id);
    }

    public void deleteBill(String id){
        billRepository.delete(id);
    }

    public List<Bill> billList(String time) {
        return billMapper.billList(time);
    }

    public List<String> getBillTime(){
        return billMapper.getBillTime();
    }
}
