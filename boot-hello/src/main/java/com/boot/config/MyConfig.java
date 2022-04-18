package com.boot.config;

import com.boot.dto.Car;
import com.boot.dto.Pet;
import com.boot.dto.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 *      Full(proxyBeanMethods = true) 【保证每个@Bean方法被调用多少次返回的组件都是单实例的】  单例
 *      Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】     多例
 *      组件依赖必须使用 Full 模式默认。其他默认是 Lite 模式
 */
@Configuration(proxyBeanMethods = true)//表示这是配置类 == 配置文件(bean.xml) 代理对象调用方法时,SpringBoot总会检查这个组件是否在容器中有,较耗时
//@EnableConfigurationProperties(Car.class)
//1、开启Car配置绑定功能
//2、把Car组件自动注册到容器中
public class MyConfig {//class->JavaBean
    /**
     * Full(proxyBeanMethods = true) 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */
    @Bean//给容器中添加组件.方法名-组件id.返回类型-组件类型.返回的值-组件在容器中的实例
    public User user(){
        User lisi=new User("lisi",12);
        //user组件依赖了Pet组件 组件依赖必须使用 Full 模式
        lisi.setPet(tomcatPet());
        return lisi;
    }

    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
