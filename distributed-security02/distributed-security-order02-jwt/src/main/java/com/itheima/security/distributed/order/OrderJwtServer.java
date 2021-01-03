package com.itheima.security.distributed.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 使用 jwt 令牌步骤：
 * 1 使用 JwtTokenStore
 * 2 去掉远程验证服务
 * @author Administrator
 * @version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderJwtServer {
    public static void main(String[] args) {
        SpringApplication.run(OrderJwtServer.class, args);
    }
}
