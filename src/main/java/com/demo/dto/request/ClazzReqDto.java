package com.demo.dto.request;

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
public class ClazzReqDto {

    private String clazzCode;
    private String clazzName;
    private String schoolCode;
    private String gradeCode;
}
