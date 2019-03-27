package com.demo.dao;

import com.demo.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2019/2/18.
 */
@Repository
public interface SchoolRepository extends JpaRepository<School,Long> {
    School findBySchoolCode(String schoolCode);
}
