package com.demo.dao;

import com.demo.entity.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by Administrator on 2019/2/21.
 */
public interface StudentRepository extends JpaRepository<Student,Long>,JpaSpecificationExecutor {
    Student findByStudentNo(String studentNo);
}
