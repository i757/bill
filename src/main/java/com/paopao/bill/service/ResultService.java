package com.paopao.bill.service;

import com.paopao.bill.bean.InOut;
import com.paopao.bill.bean.Result;
import com.paopao.bill.dao.BillRepository;
import com.paopao.bill.dao.InOutRepository;
import com.paopao.bill.dao.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 罗高杨 on 2018-3-4.
 */
@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private InOutRepository inOutRepository;

    @Autowired
    private BillRepository billRepository;

    @Transactional(rollbackFor = Exception.class)
    public void saveResult(Result result, List<InOut> inOuts,String time,String statusTime){
        resultRepository.save(result);
        inOutRepository.save(inOuts);
        billRepository.updateStatusByTime(time,statusTime);
    }
}
