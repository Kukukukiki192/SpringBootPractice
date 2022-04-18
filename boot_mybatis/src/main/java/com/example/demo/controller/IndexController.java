package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.bean.Account;
import com.example.demo.bean.City;
import com.example.demo.bean.User;
import com.example.demo.mapper.CityMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.AccountService;
import com.example.demo.service.CityService;
import com.example.demo.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class IndexController {

    @Autowired
    AccountService accountService;

    @Autowired
    CityService cityService;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/acct")
    public Account getAcctById(@RequestParam("id") Long id){
        return accountService.getAccById(id);
    }

    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getById(id);
    }

    @PostMapping("/city/save")
    public City saveCity(City city){
        cityService.saveCity(city);
        return city;
    }

    @GetMapping("/user")
    public List<User> getAll(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        List<User> userList = userService.list();
        //构造分页参数
        Page<User> page=new Page<>(pn, 3); //(当前页,)
        //调用page进行分页
        Page<User> userPage = userService.page(page,null);
        userPage.getRecords();
        userPage.getCurrent();
        userPage.getPages();

        log.info("count(user):{}", userList.size());
        return userList;
    }



}
