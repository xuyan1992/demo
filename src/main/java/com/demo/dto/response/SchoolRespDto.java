package com.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/2/18.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchoolRespDto {
    private String id;
    private String version;
    private String creatTime;
    private String updateTime;
    private String schoolCode;
    private String schoolName;
}
