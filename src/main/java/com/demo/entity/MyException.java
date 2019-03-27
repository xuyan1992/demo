package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Created by Administrator on 2019/2/19.
 */
@AllArgsConstructor
@Data
public class MyException extends RuntimeException {

    private int code;
    private String msg;

}
