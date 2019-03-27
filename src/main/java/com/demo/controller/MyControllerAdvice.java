package com.demo.controller;

import com.demo.dto.response.BaseRespDto;
import com.demo.dto.response.ResultDto;
import com.demo.entity.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.lang.reflect.InvocationTargetException;

/**
 * @ControllerAdvice 注解，可以用于定义@ExceptionHandler、@InitBinder、@ModelAttribute
 * Created by Administrator on 2019/2/19.
 */
@ControllerAdvice
@Slf4j
public class MyControllerAdvice  {

    /**
     * 处理系统未捕获异常
     * @param e
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public BaseRespDto handleSystemsException(Exception e){
        log.error(e.getMessage());
        ResultDto resultDto = ResultDto.builder().httpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()).msg("系统异常:" + e.getMessage()).build();
        return new BaseRespDto(resultDto, null);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseRespDto handleSystemsException(MethodArgumentNotValidException e){
        log.error(e.getMessage());
        StringBuilder errorMsg = new StringBuilder();
        e.getBindingResult().getAllErrors()
                .stream()
                .forEach(objectError ->
                        errorMsg.append(objectError.getDefaultMessage())
                                .append(";"));

        ResultDto resultDto = ResultDto.builder().httpStatus(HttpStatus.BAD_REQUEST.value()).msg(errorMsg.toString()).build();
        return new BaseRespDto(resultDto , null);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public BaseRespDto handleSystemsException(ConstraintViolationException e){
        log.error(e.getMessage());
        StringBuilder errorMsg = new StringBuilder();
        e.getConstraintViolations()
                .forEach(objectError ->
                        errorMsg.append(objectError.getMessage())
                                .append(";"));

        ResultDto resultDto = ResultDto.builder().httpStatus(HttpStatus.BAD_REQUEST.value()).msg(errorMsg.toString()).build();
        return new BaseRespDto(resultDto, null);
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvocationTargetException.class)
    public BaseRespDto handleSystemsException(InvocationTargetException e){
        log.error(e.getMessage());
        ResultDto resultDto = ResultDto.builder().httpStatus(HttpStatus.BAD_REQUEST.value()).msg(e.toString()).build();
        return new BaseRespDto(resultDto, null);
    }

    @ResponseBody
    @ExceptionHandler
    public BaseRespDto handleSystemsException(MyException e){
        log.error(e.getMessage());
        ResultDto resultDto = ResultDto.builder().httpStatus(e.getCode()).msg(e.toString()).build();
        return new BaseRespDto(resultDto, null);
    }

}
