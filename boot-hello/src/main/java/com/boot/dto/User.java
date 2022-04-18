package com.boot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @JsonProperty("user_name")//指定别名
    private String name;

    private String id;
    private Integer age;

//    @JsonIgnore//该字段不会序列化给前端,保证安全
    private String psw;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)//空字段不返回
    private Pet pet;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")//指定日期格式
    private Date createTime;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, Integer age, String psw, Date createTime) {
        this.name = name;
        this.age = age;
        this.psw = psw;
        this.createTime = createTime;
    }
}
