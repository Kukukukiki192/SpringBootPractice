package com.example.demo.dao;

import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 员工dao
 */
public class EmployeeDao {

    //模拟DB中的数据
    private static Map<Integer, Employee> employees=null;

    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001,new Employee(1001,"A","A24737673@qq.com",0,));
        employees.put(1002,new Employee(1002,"运维部"));
        employees.put(1003,new Employee(1003,"渠道部"));
        employees.put(1004,new Employee(1004,"方案部"));
        employees.put(1005,new Employee(1005,"人事部"));
    }

    //获得所有部门信息
    public Collection<Employee> employees(){
        return employees.values();
    }

    //通过id得到部门
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
}
