package com.demo.controller;

import com.demo.dao.ClazzRepository;
import com.demo.dao.GradeRepository;
import com.demo.dao.SchoolRepository;
import com.demo.dto.request.ClazzReqDto;
import com.demo.dto.response.*;
import com.demo.entity.Clazz;
import com.demo.entity.Grade;
import com.demo.entity.MyException;
import com.demo.entity.School;
import com.demo.mapper.ClazzMapper;
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

/**
 * Created by Administrator on 2019/2/22.
 */
@Slf4j
@RequestMapping("/clazzes")
@RestController
public class ClazzController {
    @Autowired
    private ClazzRepository clazzRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @PostMapping("/save")
    public BaseRespDto<ClazzRespDto> saveClazz(@RequestBody ClazzReqDto clazzReqDto){
        BaseRespDto<ClazzRespDto> baseClazzRespDto = new BaseRespDto<ClazzRespDto>();
        /**
         * 1.  解析请求报文
         */
        log.info("开始解析请求报文");
        String clazzCode = clazzReqDto.getClazzCode();
        String clazzName = clazzReqDto.getClazzName();
        String schoolCode = clazzReqDto.getSchoolCode();
        String gradeCode = clazzReqDto.getGradeCode();

        if(StringUtils.isEmpty(clazzCode)){
            throw new MyException(HttpStatus.BAD_REQUEST.value(),"班级代码不能为空！");
        }

        if(StringUtils.isEmpty(clazzName)){
            throw new MyException(HttpStatus.BAD_REQUEST.value(),"班级名称不能为空！");
        }

        School school = null;
        if(StringUtils.isEmpty(schoolCode)){
            throw new MyException(HttpStatus.BAD_REQUEST.value(),"所属学校代码不能为空！");
        }
        school = schoolRepository.findBySchoolCode(schoolCode);
        if(school == null){
            throw new MyException(HttpStatus.BAD_REQUEST.value(),"学校代码填写有误，学校不存在！");
        }

        Grade grade = null;
        if(StringUtils.isEmpty(gradeCode)){
            throw new MyException(HttpStatus.BAD_REQUEST.value(),"所属年级代码不能为空！");
        }
        grade = gradeRepository.findByGradeCode(gradeCode);
        if(grade == null){
            throw new MyException(HttpStatus.BAD_REQUEST.value(),"年级代码填写有误，年级不存在！");
        }
        log.info("解析请求报文完毕");

        /**
         * 2.  保存clazz对象
         */
        Clazz clazz = new Clazz();
        clazz.setClazzCode(clazzCode);
        clazz.setClazzName(clazzName);
        clazz.setSchool(school);
        clazz.setGrade(grade);
        clazzRepository.save(clazz);
        log.info("clazz对象保存成功！");

        /**
         * 3.  组装返回报文
         */
        log.info("开始组装返回报文");

        log.info("组装resultDto");
        ResultDto resultDto = ResultDto.builder().httpStatus(HttpStatus.CREATED.value()).msg("保存成功！").build();
        baseClazzRespDto.setResult(resultDto);

        //根据clazzCode查询Clazz对象
        Clazz clazz2 = clazzRepository.findByClazzCode(clazzCode);
        log.info("根据clazz对象mapper成ClazzRespDto");
        ClazzRespDto clazzRespDto = ClazzMapper.MAPPER.clazzToClazzRespDto(clazz2);

        /*log.info("根据school对象mapper成SchoolRespDto");
        SchoolRespDto schoolRespDto = SchoolMapper.MAPPER.schoolToSchoolRespDto(school);
        clazzRespDto.setSchool(schoolRespDto);

        log.info("根据grade对象mapper成GradeRespDto");
        GradeRespDto gradeRespDto = GradeMapper.MAPPER.gradeToGradeRespDto(grade);
        clazzRespDto.setGrade(gradeRespDto);*/

        baseClazzRespDto.setData(clazzRespDto);
        log.info("组装返回报文成功！");

        return baseClazzRespDto;
    }
}
