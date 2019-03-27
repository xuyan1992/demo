package com.demo.controller;

import com.demo.dao.GradeRepository;
import com.demo.dao.SchoolRepository;
import com.demo.dto.request.GradeReqDto;
import com.demo.dto.response.BaseRespDto;
import com.demo.dto.response.GradeRespDto;
import com.demo.dto.response.ResultDto;
import com.demo.dto.response.SchoolRespDto;
import com.demo.entity.Grade;
import com.demo.entity.MyException;
import com.demo.entity.School;
import com.demo.mapper.GradeMapper;
import com.demo.mapper.SchoolMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2019/2/20.
 */
@Slf4j
@RestController
@RequestMapping("/grades")
public class GradeController {
    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @PostMapping("/save")
    public BaseRespDto<GradeRespDto> saveGrade(@RequestBody GradeReqDto gradeReqDto, HttpServletResponse response) throws Exception {
        BaseRespDto<GradeRespDto> baseGradeRespDto = new BaseRespDto<GradeRespDto>();
        /**
         * 解析请求报文
         */
        String gradeCode = gradeReqDto.getGradeCode();
        String gradeName = gradeReqDto.getGradeName();

        if(StringUtils.isEmpty(gradeCode)){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            throw new MyException(HttpStatus.BAD_REQUEST.value(),"年级代码不能为空！");
        }

        if(StringUtils.isEmpty(gradeName)){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            throw new MyException(HttpStatus.BAD_REQUEST.value(),"年级代码不能为空！");
        }

        /**
         * 保存Grade对象
         */
        log.info("解析请求报文成功，开始保存grade对象！");
        Grade grade = Grade.builder().gradeCode(gradeCode).gradeName(gradeName).build();
        gradeRepository.save(grade);
        log.info("保存grade对象成功！");

        /**
         * 组装返回报文
         */
        log.info("开始组装返回报文");
        log.info("组装resultDto");
        ResultDto resultDto = ResultDto.builder().httpStatus(HttpStatus.CREATED.value()).msg("保存成功！").build();
        baseGradeRespDto.setResult(resultDto);

        log.info("根据grade对象mapper成GradeRespDto");
        Grade grade2 = gradeRepository.findByGradeCode(gradeCode);
        GradeRespDto gradeRespDto = GradeMapper.MAPPER.gradeToGradeRespDto(grade2);
        baseGradeRespDto.setData(gradeRespDto);

        log.info("组装返回报文完成！");

        return baseGradeRespDto;
    }
}
