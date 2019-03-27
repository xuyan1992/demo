package com.demo.service.impl;

import com.demo.dao.StudentRepository;
import com.demo.entity.MyException;
import com.demo.entity.Student;
import com.demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;

/**
 * Created by Administrator on 2019/2/22.
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;



    @Override
    public List<Student> findAllStudent(Integer pageNum, Integer pageSize,String sortValue) {
        List<Student> studentList = studentRepository.findAll(new PageRequest(pageNum,pageSize,new Sort(Sort.Direction.DESC, sortValue))).getContent();
        return  studentList;
    }

    @Override
    public List<Student> findAllStudent2(Integer pageNum, Integer pageSize, String sortValue, String schoolCode, String simpleName) {
        if(StringUtils.isEmpty(sortValue)){
            throw new MyException(HttpStatus.BAD_REQUEST.value(),"排序标识字段不能为空！");
        }

        if(StringUtils.isEmpty(schoolCode)){
            throw new MyException(HttpStatus.BAD_REQUEST.value(),"学校代码不能为空！");
        }

        if(StringUtils.isEmpty(simpleName)){
            throw new MyException(HttpStatus.BAD_REQUEST.value(),"学生小名不能为空！");
        }

        List<Student> studentList = studentRepository.findAll(new Specification<Student>(){

            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(cb.equal(root.get("clazz").get("school").get("schoolCode").as(String.class),  schoolCode) );
                predicates.add(cb.like(root.get("simpleName").as(String.class), "%"+simpleName+"%"));

                Predicate[] pre = new Predicate[predicates.size()];
                query.where(predicates.toArray(pre));
                return cb.and(predicates.toArray(pre));
            }

        },new PageRequest(pageNum,pageSize,new Sort(Sort.Direction.DESC,sortValue))).getContent();

        return studentList;
    }


}
