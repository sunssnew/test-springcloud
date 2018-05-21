package com.wangfan.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//断路器仪表盘
@EnableHystrixDashboard
public class FeignService {

    public static void main(String[] args) {
        SpringApplication.run(FeignService.class, args);
    }
}