package com.paopao.bill.controller;

import com.paopao.bill.bean.InOut;
import com.paopao.bill.bean.Result;
import com.paopao.bill.bean.UserMoney;
import com.paopao.bill.service.BillService;
import com.paopao.bill.service.ResultService;
import com.paopao.bill.service.UserService;
import com.paopao.bill.util.ApiException;
import com.paopao.bill.util.ApiUtils;
import com.paopao.bill.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 罗高杨 on 2018-3-4.
 */
@Controller
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @Autowired
    private UserService userService;

    @Autowired
    private BillService billService;

    @RequestMapping(value = "/settle",method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void result(String time){
        String resultId = ApiUtils.getUUID();
        String resultTime = ApiUtils.now();
        Result result = new Result();
        result.setId(resultId);
        result.setResultTime(resultTime);
        String[] strs = time.split("-");
        result.setMonth(Integer.parseInt(strs[1]));
        result.setYear(Integer.parseInt(strs[0]));

        List<String> users = userService.getUsers();
        List<UserMoney> userMoney = billService.getUserMoney(time);
        if(userMoney == null || userMoney.size() == 0){
            throw new ApiException(Constants.NO_BILL_RESULT);
        }
        double total = 0;
        for(UserMoney map : userMoney){
            total = total + map.getUserMoney();
        }
        DecimalFormat df = new DecimalFormat("0.0");

        double avgMoney = Double.parseDouble(df.format(total / users.size()));
        result.setAvg(avgMoney);

        List<InOut> inOuts = new ArrayList<>();
        for(UserMoney map : userMoney){
            InOut inOut = new InOut();
            inOut.setId(ApiUtils.getUUID());
            inOut.setInMoney(map.getUserMoney() - avgMoney);
            inOut.setOutMoney(map.getUserMoney());
            inOut.setUserId(map.getUserId());
            inOut.setResultId(resultId);
            inOuts.add(inOut);
            users.remove(map.getUserId());
        }

        for(String userId : users){
            InOut inOut = new InOut();
            inOut.setId(ApiUtils.getUUID());
            inOut.setInMoney(-avgMoney);
            inOut.setOutMoney(0.0);
            inOut.setUserId(userId);
            inOut.setResultId(resultId);
            inOuts.add(inOut);
        }

        resultService.saveResult(result,inOuts,time,ApiUtils.now());
    }
}
