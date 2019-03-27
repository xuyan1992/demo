package com.demo.dto.response;

import com.demo.entity.Grade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/2/22.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClazzRespDto {
    private String id;
    private String version;
    private String creatTime;
    private String updateTime;
    private String clazzCode;
    private String clazzName;
    private SchoolRespDto school;
    private GradeRespDto grade;
}
