package com.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/2/20.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GradeReqDto {

    private String gradeCode;
    private String gradeName;
}
