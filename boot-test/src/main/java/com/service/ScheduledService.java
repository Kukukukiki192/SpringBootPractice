package com.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ScheduledService {

    // 根据约定的时间来执行特定的作务
    // cron表达式  秒 分 时 日 月 周几0-7(0/7-周日) ?表示不确定
    @Scheduled(cron = "30 34 13 * * ?")
    public void hello(){
        log.info("hello~");
    }
}
