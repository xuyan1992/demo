package com.demo.controller;

import com.demo.dao.EmployeeRepository;
import com.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/2/15.
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/getEmployees/{pageNum}/{pageSize}")
    public List<Employee> findAllEmployees(@PathVariable("pageNum") Integer pageNum,
                                           @PathVariable("pageSize") Integer pageSize) {
        return employeeRepository.findAll(new PageRequest(pageNum,pageSize,new Sort(Sort.Direction.DESC,"id"))).getContent() ;
    }
}
