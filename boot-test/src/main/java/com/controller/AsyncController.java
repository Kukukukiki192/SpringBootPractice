package com.controller;

import com.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("hello")
    public String hello(){
        asyncService.hello(); // 未开启异步任务时停止3s(转圈~) 开启后瞬间刷新
        return "OK";
    }
}
