package com.boot.controller;

import com.boot.dto.User;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownServiceException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class GetController {
    private Map<String,Object> params=new HashMap<>();

    /**
     * 测试restful协议,从路径中获取字段
     * 查询-Get
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/{user_name}/{user_age}")
    public Object findUser(@PathVariable("user_name") String name, @PathVariable("user_age") Integer age){
        params.clear();
        params.put("name",name);
        params.put("age",age);
        System.out.println("热部署");
        return params;
    }

    /**
     * Bean对象传参
     * 保存/提交-Post
     * 注：1.须指定http头为content-type:application/json 2.使用body传输数据
     * @param user
     * @return
     */
    @PostMapping("/saveUser")
    public Object saveUser(@RequestBody User user){
        params.clear();
        params.put("user", user);
        System.out.println(params);
        return params;
    }

    @GetMapping("/testJson")
    public Object testJson(){
        return new User("xx",11,"sdkfugy9",new Date());
    }

    @PostMapping("/post")//提交
    public Object login(String id, String  psw){
        params.clear();
        params.put("id",id);
        params.put("psw",psw);
        return params;
    }

    @PutMapping("/put")//更新
    public Object put(String id){
        params.clear();
        params.put("id",id);
        return params;
    }

    @DeleteMapping("/del")//删除
    public Object del(String id){
        params.clear();
        params.put("id",id);
        return params;
    }


}
