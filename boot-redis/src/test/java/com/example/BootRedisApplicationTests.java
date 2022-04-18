package com.example;

import com.example.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class BootRedisApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        //操作字符串 类似String
        redisTemplate.opsForValue().set("key1","lalaal");
        System.out.println(redisTemplate.opsForValue().get("key1"));
    }

    @Test
    void test1() {
        User user=new User("小飞",3);
        String jsonUser= JSONValue.toJSONString(user);
//        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("key2",user);
        System.out.println(redisTemplate.opsForValue().get("key2"));
    }

}
