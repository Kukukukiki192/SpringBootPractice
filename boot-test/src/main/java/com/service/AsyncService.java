package com.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Async注解会在以下几个场景失效，也就是说明明使用了@Async注解，但就没有走多线程:
 * 1. 异步方法使用static关键词修饰
 * 2. 异步类不是一个Spring容器的bean（一般使用注解@Component和@Service，并且能被Spring扫描到）
 * 3. SpringBoot应用中没有添加@EnableAsync注解
 * 4. 在同一个类中，一个方法调用另外一个有@Async注解的方法，注解不会生效。原因是@Async注解的方法，是在代理类中执行的
 */
@Service
public class AsyncService {

    @Async ////在需要异步的方法上加@Async 指定使用beanName为..的线程池
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据处理ing");
    }
}
