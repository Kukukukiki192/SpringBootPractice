package com.example.demo.dao;

import com.example.demo.pojo.Department;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 部门dao
 */
public class DepartmentDao {

    //模拟DB中的数据
    private static Map<Integer, Department> departments=null;

    static {
        departments = new HashMap<Integer, Department>();
        departments.put(101,new Department(101,"研发部"));
        departments.put(102,new Department(102,"运维部"));
        departments.put(103,new Department(103,"渠道部"));
        departments.put(104,new Department(104,"方案部"));
        departments.put(105,new Department(105,"人事部"));
    }

    //获得所有部门信息
    public Collection<Department> departments(){
        return departments.values();
    }

    //通过id得到部门
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
