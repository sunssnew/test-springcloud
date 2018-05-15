package com.wangfan.application.service;

public class ServiceHiHystric implements  ServiceHi{

	@Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
