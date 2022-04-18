package com.example.admin.controller;

import com.example.admin.dto.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/boot")
public class HelloController {
    @Autowired
    Car car;//MyConfig->Bean

    @GetMapping("/car")
    public Car car(){
        return car;
    }

    @RequestMapping("/hello")
    public String hello(){
        log.info("请求进来了....");
        return "hello,SpringBoot2!";

    }
}
