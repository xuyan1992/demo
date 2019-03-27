package com.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/2/18.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SchoolReqDto {
    private String schoolCode;
    private String schoolName;
}
