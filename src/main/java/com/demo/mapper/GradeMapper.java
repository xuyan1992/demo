package com.demo.mapper;

import com.demo.dto.response.GradeRespDto;
import com.demo.entity.Grade;
import com.demo.entity.School;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Created by Administrator on 2019/2/21.
 */
@Mapper
public interface GradeMapper {
    GradeMapper MAPPER = Mappers.getMapper(GradeMapper.class);

    GradeRespDto gradeToGradeRespDto(Grade grade);
}
