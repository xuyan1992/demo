package com.demo.dao;

import com.demo.entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2019/2/22.
 */
@Repository
public interface ClazzRepository extends JpaRepository<Clazz,Long> {
    Clazz findByClazzCode(String clazzCode);
}
