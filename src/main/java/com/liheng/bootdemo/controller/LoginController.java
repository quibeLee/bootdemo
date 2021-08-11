package com.liheng.bootdemo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class LoginController {
    @RequestMapping("/loginPage")
    public String loginPage() {
        return "login";
    }
}
 /**   @RequestMapping("/login")
    public String login( String username, String password){

        String user = username;
        String pwd = password;
        if(user == null || password==null ){
            return "fail";
        }else if(user.equals("123") || pwd.equals("123")){
            return "success";
        }
        return "fail";
    }

}
**/