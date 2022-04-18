package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling //开启定时功能
@EnableAsync      //开启异步任务
@SpringBootApplication
public class BootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootTestApplication.class, args);
    }

}
