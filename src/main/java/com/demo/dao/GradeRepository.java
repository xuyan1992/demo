package com.demo.dao;

import com.demo.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2019/2/20.
 */
@Repository
public interface GradeRepository extends JpaRepository<Grade,Long> {

    Grade findByGradeCode(String gradeCode);

}
