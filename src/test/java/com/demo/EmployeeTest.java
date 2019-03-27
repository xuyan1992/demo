package com.demo;

import com.demo.dao.EmployeeRepository;
import com.demo.dto.response.EmployeeDto;
import com.demo.entity.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2019/2/15.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class EmployeeTest {

    @Autowired
    private EmployeeRepository employeeRepository;

   // @Test
    public void testAdd(){
        Employee employee1 = new Employee();
        employee1.setName("张七");
        employee1.setAge("20");
        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setName("李八");
        employee2.setAge("20");
        employeeRepository.save(employee2);

        Employee employee3 = new Employee();
        employee3.setName("王九");
        employee3.setAge("20");
        employeeRepository.save(employee3);

        Employee employee4 = new Employee();
        employee4.setName("吴十");
        employee4.setAge("20");
        employeeRepository.save(employee4);

    }


}
