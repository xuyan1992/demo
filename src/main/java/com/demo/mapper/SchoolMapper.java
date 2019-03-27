package com.demo.mapper;

import com.demo.dto.response.SchoolRespDto;
import com.demo.entity.School;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Created by Administrator on 2019/2/19.
 */
@Mapper
public interface SchoolMapper {
    SchoolMapper MAPPER = Mappers.getMapper(SchoolMapper.class);

    @Mappings({})
    SchoolRespDto schoolToSchoolRespDto(School school);
}
