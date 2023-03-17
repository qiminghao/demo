package com.haohaoit.demo.service.service;

import com.haohaoit.demo.contract.service.IHelloService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String str) {
        return "Hello, " + str + " (from Dubbo with Spring Boot)";
    }
}
