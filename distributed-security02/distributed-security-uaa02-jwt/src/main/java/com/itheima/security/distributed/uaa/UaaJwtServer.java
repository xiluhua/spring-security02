package com.itheima.security.distributed.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 使用 jwt 令牌步骤：
 * 1 使用 JwtTokenStore
 * 2 添加令牌增强到 AuthorizationServerTokenServices
 * @author Administrator
 * @version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients(basePackages = {"com.itheima.security.distributed.uaa"})
public class UaaJwtServer {
    public static void main(String[] args) {
        SpringApplication.run(UaaJwtServer.class, args);
    }
}
