package com.example.demo.service;

import com.example.demo.bean.Account;
import com.example.demo.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAccById(Long id){
        return accountMapper.getAcct(id);
    }
}
