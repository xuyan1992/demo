package com.demo.service;

import com.demo.entity.Student;

import java.util.List;

/**
 * Created by Administrator on 2019/2/22.
 */
public interface StudentService {
    List<Student> findAllStudent(Integer pageNum, Integer pageSize,String sortValue);

    List<Student> findAllStudent2(Integer pageNum, Integer pageSize,String sortValue,String schoolCode,String simpleName);


}
