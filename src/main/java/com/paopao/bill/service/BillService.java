package com.paopao.bill.service;

import com.paopao.bill.bean.Bill;
import com.paopao.bill.dao.BillRepository;
import com.paopao.bill.dao.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return billRepository.findById(id);
    }

    public void deleteBill(String id){
        billRepository.delete(id);
    }

    public List<Bill> billList(String time) {
        Map<String,String> map = new HashMap<>();
        map.put("time",time);
        return billMapper.billList(map);
    }

    public List<String> getBillTime(){
        return billMapper.getBillTime();
    }
}
