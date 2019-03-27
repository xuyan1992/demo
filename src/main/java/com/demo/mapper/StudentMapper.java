package com.demo.mapper;

import com.demo.dto.response.StudentRespDto;
import com.demo.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by Administrator on 2019/2/22.
 */
@Mapper
public interface StudentMapper {
    StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

    StudentRespDto studentToStudentRespDto(Student student);
}
