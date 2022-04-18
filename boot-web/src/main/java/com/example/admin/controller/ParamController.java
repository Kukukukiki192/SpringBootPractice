package com.example.admin.controller;

import org.apache.tomcat.util.http.parser.Cookie;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/param")
public class ParamController {


    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,//路径变量
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv,

//                                     @RequestHeader("User-Agent") String userAgent,//获取请求头
//                                     @RequestHeader Map<String,String> header,
//
//                                     @RequestParam Integer age,         //获取请求参数
//                                     @RequestParam List<String> skill,
//                                     @RequestParam Map<String,String> params,//Map重复的key会被覆盖 skill集合有多个值，存入Map中只有一个
//                                     @RequestParam MultiValueMap<String,String> params1, //MultiValueMap可以接收重复key

                                     @CookieValue("_ga") String _ga,
                                     @CookieValue("_ga") Cookie cookie ) {
        Map<String,Object> map=new HashMap<>();
//        map.clear();
//        map.put("id",id);
//        map.put("name",name);
//        map.put("pv",pv);
//        map.put("userAgent",userAgent);
//        map.put("header",header);
//        map.put("age",age);
//        map.put("skill",skill);
//        map.put("params",params);
//        map.put("params1",params1);

        map.put("_ga",_ga);
        map.put("cookie",cookie);
//        System.out.println(cookie.getName()+"==>"+cookie.getValue());

        return map;
    }


}
