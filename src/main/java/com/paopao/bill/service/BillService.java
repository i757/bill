package com.paopao.bill.service;

import com.paopao.bill.bean.Bill;
import com.paopao.bill.bean.Result;
import com.paopao.bill.bean.UserMoney;
import com.paopao.bill.bean.pojo.BillGet;
import com.paopao.bill.bean.pojo.InOutBean;
import com.paopao.bill.dao.BillRepository;
import com.paopao.bill.dao.ResultRepository;
import com.paopao.bill.dao.mapper.BillMapper;
import com.paopao.bill.dao.mapper.InOutMapper;
import com.paopao.bill.dao.mapper.ResultMapper;
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

    @Autowired
    private ResultMapper resultMapper;

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private InOutMapper inOutMapper;

    public void saveBill(Bill bill){
        billRepository.save(bill);
    }

    public Bill getBill(String id){
        return billRepository.findById(id);
    }

    public void deleteBill(String id){
        billRepository.delete(id);
    }

    public List<BillGet> billList(String time) {
        Map<String,String> map = new HashMap<>();
        map.put("time",time);
        return billMapper.billList(map);
    }

    public List<Map<String,String>> getBillTime(){
        return billMapper.getBillTime();
    }

    public List<UserMoney> getUserMoney(String time){
        return billMapper.getUserMoney(time);
    }


    public List<Result> getResult(){
        return resultMapper.getResult();
    }

    public Result findResult(String id){
        return resultRepository.findOne(id);
    }

    public List<InOutBean> getInOuts(String id) {
        return inOutMapper.getInOuts(id);
    }
}
