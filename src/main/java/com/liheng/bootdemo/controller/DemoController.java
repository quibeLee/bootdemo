package com.liheng.bootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiHeng
 * @creator 2020-09-09
 *
 * *测试类
 *
 **/
@RestController
public class DemoController {
    @RequestMapping("/sayHello")
    public String sqyHello(){


        return "index";
    }
}
