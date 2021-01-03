package com.itheima.security.springboot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
public class LoginRestController {

    /**
     * 二选一 LoginController 或 LoginRestController
     */
    @RequestMapping(value = "/login-success01",produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess01(){
        //提示具体用户名称登录成功
        System.out.println("login-success ...");
        return SecurityContextHolderTool.getUsername()+" 登录成功";
    }

    /**
     * 测试资源1
     * @return
     */
    @GetMapping(value = "/r/r1",produces = {"text/plain;charset=UTF-8"})
//    @PreAuthorize("hasAuthority('p1')")//拥有p1权限才可以访问
    @PreAuthorize("hasAnyAuthority('p1','p2')")//拥有p1权限才可以访问
    public String r1(){
        return SecurityContextHolderTool.getUsername()+" 访问资源1";
    }

    /**
     * 测试资源2
     * @return
     */
    @GetMapping(value = "/r/r2",produces = {"text/plain;charset=UTF-8"})
    @PreAuthorize("hasAuthority('p2')")//拥有p2权限才可以访问
    public String r2(){
        return SecurityContextHolderTool.getUsername()+" 访问资源2";
    }

}
