package com.controller;

import com.service.AsyncService1;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class AsyncController1 {

    @Autowired
    private AsyncService1 asyncService;

    @GetMapping("/open/something")
    public String something() {
        int count = 10;
        for (int i = 0; i < count; i++) {
            asyncService.doSomething("index = " + i);
        }
        return "success";
    }

    /**
     * @SneakyThrows是lombok包下的注解 继承了Throwable
     * 作用: 是为了用try{}catch{}捕捉异常
     * 添加之后会在 代码编译时 自动捕获异常
     */
    @SneakyThrows
//    @ApiOperation("异步 有返回值")
    @GetMapping("/open/somethings")
    public String somethings() {
        //CompletableFuture是对Feature的增强，Feature只能处理简单的异步任务，而CompletableFuture可以将多个异步任务进行复杂的组合
        CompletableFuture<String> createOrder = asyncService.doSomething1("create order");
        CompletableFuture<String> reduceAccount = asyncService.doSomething2("reduce account");
        CompletableFuture<String> saveLog = asyncService.doSomething3("save log");

        // 等待所有任务都执行完
        CompletableFuture.allOf(createOrder, reduceAccount, saveLog).join();
        // 获取每个任务的返回结果
        String result = createOrder.get() + reduceAccount.get() + saveLog.get();
        return result;
    }
}

