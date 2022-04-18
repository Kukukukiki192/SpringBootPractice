package com.example.admin.mapper;

import com.example.admin.bean.City;
import org.apache.ibatis.annotations.*;

/**
 * 导入mybatis官方starter
 * 编写mapper接口。标准@Mapper注解
 * 编写sql映射文件并绑定mapper接口
 * 在application.yaml中指定Mapper配置文件的位置，以及指定全局配置文件的信息 （建议；配置在mybatis.configuration）
 */
@Mapper
public interface CityMapper {

    @Select("select * from city where id=#{id}")
    City getById(Long id);

    @Insert("insert into city(name, state, country) VALUES(#{name}, #{state}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(City city);
}
