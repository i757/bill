package com.paopao.bill.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author luoxiaozhu
 * @date 2018-2-28-0028 15:47
 */
@Controller
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        logger.info("test");
        return "test";
    }

}
