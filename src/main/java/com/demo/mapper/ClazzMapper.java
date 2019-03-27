package com.demo.mapper;

import com.demo.dto.response.ClazzRespDto;
import com.demo.entity.Clazz;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by Administrator on 2019/2/22.
 */
@Mapper
public interface ClazzMapper {
    ClazzMapper MAPPER = Mappers.getMapper(ClazzMapper.class);

    ClazzRespDto clazzToClazzRespDto(Clazz clazz);
}
