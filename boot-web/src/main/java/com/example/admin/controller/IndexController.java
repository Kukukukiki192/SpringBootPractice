package com.example.admin.controller;

import com.example.admin.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 来登录页
     * @return
     */
    @GetMapping({"/login"})
    public String loginPage(){
        return "login";
    }

    @Autowired
    private Person person;

    @GetMapping("/person")
    public Person person(){
        log.info("请求进来了....");
        return person;
    }

    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        return aLong.toString();
    }
}
