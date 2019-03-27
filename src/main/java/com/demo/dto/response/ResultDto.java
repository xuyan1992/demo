package com.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/2/19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultDto {

    private int httpStatus;

    @Builder.Default
    private String msg = "success";
}
