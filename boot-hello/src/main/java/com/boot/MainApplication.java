package com.boot;

import com.boot.config.MyConfig;
import com.boot.dto.Pet;
import com.boot.dto.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类
 */
@ServletComponentScan(basePackages = "com.boot.servlet")//指定原生Servlet组件位置
@SpringBootApplication//表示这是SpringBoot应用
public class MainApplication {
    public static void main(String[] args) {

        //1、返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class,args);
        //2、从容器中获取组件
        Pet tom1 = (Pet) run.getBean("tom");
        Pet tom2 = run.getBean("tom", Pet.class);
        System.out.println(tom1 == tom2);

        //拿到配置类
        MyConfig myConfig=run.getBean(MyConfig.class);
        //调用配置类方法
        User user1 = myConfig.user();
        User user2 = myConfig.user();
        System.out.println(user1 == user2);

        Pet tom = (Pet) run.getBean("tom");
        User user = (User) run.getBean("user");
        System.out.println(user.getPet() == tom);
    }
}
