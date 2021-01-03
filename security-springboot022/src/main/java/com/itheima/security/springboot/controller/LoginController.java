package com.itheima.security.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * @version 1.0
 **/
@Controller
public class LoginController {

    // 测试是否能正常到登录页
    @RequestMapping(value = "/login-view")
    public String login02(){
        //提示具体用户名称登录成功
        System.out.println("go to login ...");
        return "login";
    }

    /**
     * 二选一 LoginController 或 LoginRestController
     */
    @RequestMapping(value = "/login-success02")
    public String loginSuccess02(){
        //提示具体用户名称登录成功

        System.out.println("login-success ...");
        System.out.println(SecurityContextHolderTool.getUsername()+" 登录成功");

        return "success";
    }
}
