package com.example.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
    /**
     * 去登录页
     * @return
     */
    @GetMapping({"/","/login"})
    public String loginPage(){
        return "login";
    }

    /**
     * 提交表单登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String main(String username,String password){


//        return "main"; //页面跳转到了 main.html,但请求地址还是 login  刷新页面会出现重复提交问题
        return "redirect:main.html"; //登陆成功重定向到 main.html
    }

    /**
     * 去main页面
     * @return
     */
    @GetMapping("/main.html") //加 html表示要去访问该页面
    public String mainPage(){
        return "main";
    }
}
