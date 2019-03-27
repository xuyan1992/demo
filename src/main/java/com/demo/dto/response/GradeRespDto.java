package com.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/2/20.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GradeRespDto {
    private String id;
    private String version;
    private String creatTime;
    private String updateTime;
    private String gradeCode;
    private String gradeName;
}
