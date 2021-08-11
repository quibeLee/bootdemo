package com.liheng.bootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * @author LiHeng
 * @Date 2020-9-11
 *
 *     /测试/
 *
 * */


@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
