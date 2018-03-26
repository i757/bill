package com.paopao.bill.controller;

import com.paopao.bill.bean.Bill;
import com.paopao.bill.bean.Result;
import com.paopao.bill.bean.pojo.BillGet;
import com.paopao.bill.bean.pojo.InOutBean;
import com.paopao.bill.bean.pojo.ResultBean;
import com.paopao.bill.service.BillService;
import com.paopao.bill.util.ApiUtils;
import com.paopao.bill.util.ApiException;
import com.paopao.bill.util.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luoxiaozhu
 * @date 2018-3-2-0002 11:11
 */
@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void saveBill(@RequestBody Bill bill){
        bill.setId(ApiUtils.getUUID());
        bill.setSubmitTime(ApiUtils.now());
        billService.saveBill(bill);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Bill getBill(@PathVariable String id){
        Bill bill = billService.getBill(id);
        if(bill == null){
            throw new ApiException(Constants.BILL_NOT_EXIST);
        }
        return bill;
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void modifyBill(@RequestBody Bill bean){
        Bill bill = billService.getBill(bean.getId());
        if(bill == null){
            throw new ApiException(Constants.BILL_NOT_EXIST);
        }
        billService.saveBill(bean);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBill(@PathVariable String id){
        billService.deleteBill(id);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<BillGet> billList(String time){
        if(StringUtils.isBlank(time)){
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
            time = f.format(new Date());
        }
        return billService.billList(time);
    }

    @RequestMapping(value = "/history",method = RequestMethod.GET)
    @ResponseBody
    public List<Result> billHistory(){
        List<Result> results = billService.getResult();
        return results;
    }

    @RequestMapping(value = "/history/detail",method = RequestMethod.GET)
    @ResponseBody
    public Object historyDetail(@RequestParam String id){
        ResultBean bean = new ResultBean();
        Result result = billService.findResult(id);
        bean.setAvg(result.getAvg());
        bean.setResultTime(result.getResultTime());
        List<InOutBean> list = billService.getInOuts(id);
        bean.setList(list);
        return bean;
    }
}
