package com.wangfan.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//springboot启动
@SpringBootApplication

@EnableDiscoveryClient

//开启断路器
@EnableHystrix
public class RibbonService extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RibbonService.class, args);
    }
    
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RibbonService.class);
	}

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
