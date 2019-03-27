package com.demo.controller;

import com.demo.dao.SchoolRepository;
import com.demo.dto.request.SchoolReqDto;
import com.demo.dto.response.BaseRespDto;
import com.demo.dto.response.ResultDto;
import com.demo.dto.response.SchoolRespDto;
import com.demo.entity.MyException;
import com.demo.entity.School;
import com.demo.mapper.SchoolMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2019/2/18.
 */
@Slf4j
@RestController
@RequestMapping("/schools")
public class SchoolController {
    @Autowired
    private SchoolRepository schoolRepository;

    @PostMapping(value = "/save")
    public BaseRespDto<SchoolRespDto> saveSchool(@RequestBody SchoolReqDto schoolReqDto, HttpServletResponse response) throws Exception{
        BaseRespDto<SchoolRespDto> baseSchoolRespDto = new BaseRespDto<SchoolRespDto>();

        /**
         * 解析请求报文
         */
        String schoolCode  = schoolReqDto.getSchoolCode();
        String schoolName = schoolReqDto.getSchoolName();

        if(StringUtils.isEmpty(schoolCode)){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            throw new MyException(HttpStatus.BAD_REQUEST.value(),"学校代码不能为空！");
        }
        if(StringUtils.isEmpty(schoolName)){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            throw new MyException(HttpStatus.BAD_REQUEST.value(),"学校名称不能为空！");
        }

        /**
         * 保存School对象
         */
        log.info("解析请求报文成功，开始保存School对象！");
        School school = new School();
        school.setSchoolCode(schoolCode);
        school.setSchoolName(schoolName);
        schoolRepository.save(school);
        log.info("保存School成功！");

        /**
         * 组装返回报文
         */

        log.info("开始组装返回报文");
        log.info("组装resultDto");
        ResultDto resultDto = ResultDto.builder().httpStatus(HttpStatus.CREATED.value()).msg("保存成功！").build();
        baseSchoolRespDto.setResult(resultDto);

        log.info("根据学校代码查询学校");
        School school12 = schoolRepository.findBySchoolCode(schoolCode);
        log.info("根据school对象mapper成SchoolRespDto");
        SchoolRespDto schoolRespDto = SchoolMapper.MAPPER.schoolToSchoolRespDto(school12);
        baseSchoolRespDto.setData(schoolRespDto);
        log.info("组装返回报文完成");

        return  baseSchoolRespDto;
    }



}
