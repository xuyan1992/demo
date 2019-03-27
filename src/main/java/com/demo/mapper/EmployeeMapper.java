package com.demo.mapper;

import com.demo.dto.response.EmployeeDto;
import com.demo.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Created by Administrator on 2019/2/20.
 */
@Mapper
public interface EmployeeMapper {
    EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);

    @Mappings({})
    EmployeeDto employeeToEmployeeDto(Employee employee);
}
