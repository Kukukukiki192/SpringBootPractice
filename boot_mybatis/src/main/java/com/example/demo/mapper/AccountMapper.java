package com.example.demo.mapper;

import com.example.demo.bean.Account;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface AccountMapper {
    Account getAcct(Long id);
}
