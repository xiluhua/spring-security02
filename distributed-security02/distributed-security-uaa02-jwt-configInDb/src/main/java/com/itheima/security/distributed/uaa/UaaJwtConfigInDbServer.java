package com.itheima.security.distributed.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 1 设置授权码模式从数据库读取 JdbcAuthorizationCodeServices
 * 2 设置 ClientDetails 从数据库读取 JdbcClientDetailsService
 * @author Administrator
 * @version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients(basePackages = {"com.itheima.security.distributed.uaa"})
public class UaaJwtConfigInDbServer {
    public static void main(String[] args) {
        SpringApplication.run(UaaJwtConfigInDbServer.class, args);
    }
}
