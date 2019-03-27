package com.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Created by Administrator on 2019/2/18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseRespDto<T> {
    private ResultDto result;

    private T data;
}
