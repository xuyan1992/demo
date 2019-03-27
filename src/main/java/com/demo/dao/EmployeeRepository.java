package com.demo.dao;

import com.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2019/2/15.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
