package com.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @Async注解会在以下几个场景失效，也就是说明明使用了@Async注解，但就没有走多线程:
 * 1. 异步方法使用static关键词修饰
 * 2. 异步类不是一个Spring容器的bean（一般使用注解@Component和@Service，并且能被Spring扫描到）
 * 3. SpringBoot应用中没有添加@EnableAsync注解
 * 4. 在同一个类中，一个方法调用另外一个有@Async注解的方法，注解不会生效。原因是@Async注解的方法，是在代理类中执行的
 */
@Slf4j
@Service
public class AsyncService1 {

    //在需要异步的方法上加@Async 指定使用beanName为doSomethingExecutor的线程池
    @Async("doSomethingExecutor") //在执行此方法时,会单独开启线程来执行
    public String doSomething(String message) {
        System.out.println("当前线程："+Thread.currentThread().getName());
        log.info("do something, message={}", message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("do something error: ", e);
        }
        return message;
    }

    @Async("doSomethingExecutor")
    public CompletableFuture<String> doSomething1(String message) throws InterruptedException {
        System.out.println("当前线程1："+Thread.currentThread().getName());
        log.info("do something1: {}", message);
        Thread.sleep(1000);
        return CompletableFuture.completedFuture("do something1: " + message);
    }

    @Async("doSomethingExecutor")
    public CompletableFuture<String> doSomething2(String message) throws InterruptedException {
        System.out.println("当前线程2："+Thread.currentThread().getName());
        log.info("do something2: {}", message);
        Thread.sleep(1000);
        return CompletableFuture.completedFuture("; do something2: " + message);
    }

    @Async("doSomethingExecutor")
    public CompletableFuture<String> doSomething3(String message) throws InterruptedException {
        System.out.println("当前线程3："+Thread.currentThread().getName());
        log.info("do something3: {}", message);
        Thread.sleep(1000);
        return CompletableFuture.completedFuture("; do something3: " + message);
    }
}