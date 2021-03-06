package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 员工表
 */
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender; //0-女 1-男
    private String departmentName;
    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer gender, String departmentName) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.departmentName = departmentName;
        this.birth=new Date();
    }
}
