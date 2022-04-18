package com.boot.controller;

import com.boot.dto.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
