package com.demo.controller;

import com.demo.dao.ClazzRepository;
import com.demo.dao.StudentRepository;
import com.demo.dto.request.StudentReqDto;
import com.demo.dto.response.BaseRespDto;
import com.demo.dto.response.ResultDto;
import com.demo.dto.response.StudentRespDto;
import com.demo.entity.*;
import com.demo.enums.Gender;
import com.demo.mapper.StudentMapper;
import com.demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/2/21.
 */
@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClazzRepository clazzRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private DiscoveryClient client;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");

    @PostMapping("/save")
    public BaseRespDto<StudentRespDto> saveStudent(@RequestBody StudentReqDto studentReqDto, HttpStatus httpStatus) throws Exception {

        BaseRespDto<StudentRespDto> baseStudentRespDto = new BaseRespDto<StudentRespDto>();
        /**
         * 1. 解析请求报文
         */
        log.info("开始解析请求报文");
        String studentNo = studentReqDto.getStudentNo();
        String userName = studentReqDto.getUserName();
        String password = studentReqDto.getPassword();
        String age = studentReqDto.getAge();
        String simpleName = studentReqDto.getSimpleName();
        String birthday = studentReqDto.getBirthday();
        String gender = studentReqDto.getGender();
        String clazzCode = studentReqDto.getClazzCode();

        if (StringUtils.isEmpty(studentNo)) {
            throw new MyException(HttpStatus.BAD_REQUEST.value(), "学生学号不能为空！");
        }

        if (StringUtils.isEmpty(userName)) {
            throw new MyException(HttpStatus.BAD_REQUEST.value(), "学生姓名不能为空！");
        }

        Clazz clazz = null;
        if (StringUtils.isEmpty(clazzCode)) {
            throw new MyException(HttpStatus.BAD_REQUEST.value(), "所属班级代码不能为空！");
        }
        clazz = clazzRepository.findByClazzCode(clazzCode);
        if (clazz == null) {
            throw new MyException(HttpStatus.BAD_REQUEST.value(), "班级代码填写有误，年级不存在！");
        }
        log.info("解析请求报文完毕");


        /**
         * 2. 保存student对象
         */

        Student student = new Student();
        student.setStudentNo(studentNo);
        student.setUserName(userName);
        student.setSimpleName(simpleName);
        student.setPassword(password);
        student.setAge(age);
        student.setGender(Gender.parseName(gender));
        student.setBirthDay(sdf.parse(birthday));
        student.setClazz(clazz);
        studentRepository.save(student);
        log.info("student对象保存成功！");

        /**
         * 3. 组装返回报文
         */
        log.info("开始组装返回报文");

        log.info("组装resultDto");
        ResultDto resultDto = ResultDto.builder().httpStatus(HttpStatus.CREATED.value()).msg("保存成功！").build();
        baseStudentRespDto.setResult(resultDto);

        //根据studentCode查询Student
        Student student2 = studentRepository.findByStudentNo(studentNo);
        log.info("根据student对象mapper为StudentRespDto");
        StudentRespDto studentRespDto = StudentMapper.MAPPER.studentToStudentRespDto(student2);

        baseStudentRespDto.setData(studentRespDto);
        log.info("组装返回报文成功！");

        return baseStudentRespDto;
    }

    @GetMapping("/student/{studentNo}")
    public BaseRespDto<StudentRespDto> findByStudentCode(@PathVariable String studentNo, HttpServletResponse response) {
        BaseRespDto<StudentRespDto> baseStudentRespDto = new BaseRespDto<StudentRespDto>();
        Student student = studentRepository.findByStudentNo(studentNo);
        if (student == null) {
            log.info("根据输入学号没有查询到学生！");
        }
        StudentRespDto studentRespDto = StudentMapper.MAPPER.studentToStudentRespDto(student);
        log.info("开始组装返回报文");

        log.info("组装resultDto");
        ResultDto resultDto = ResultDto.builder().httpStatus(HttpStatus.OK.value()).msg("").build();
        baseStudentRespDto.setResult(resultDto);
        baseStudentRespDto.setData(studentRespDto);
        log.info("组装返回报文成功！");
        return baseStudentRespDto;

    }

    @GetMapping("/{pageNum}/{pageSize}")
    public BaseRespDto<List<StudentRespDto>> getStudents(@PathVariable Integer pageNum, @PathVariable Integer pageSize, @RequestParam(value = "sortValue", required = true) String sortValue) {
        //BaseRespDto<List<StudentRespDto>> baseStudentRespDto = new BaseRespDto<List<StudentRespDto>>();
        ServiceInstance instance = client.getLocalServiceInstance();
        log.info("/student, host:"+instance.getHost() +",service_id:"+instance.getServiceId());
        List<Student> studentList = studentService.findAllStudent(pageNum, pageSize, sortValue);

        log.info("开始组装返回报文");
        List<StudentRespDto> studentRespDtos = new ArrayList<StudentRespDto>();
        if (studentList != null && studentList.size() > 0) {
            for (Student s : studentList) {
                StudentRespDto studentRespDto = StudentMapper.MAPPER.studentToStudentRespDto(s);
                studentRespDtos.add(studentRespDto);
            }
        }

        ResultDto resultDto = ResultDto.builder().httpStatus(HttpStatus.OK.value()).msg("").build();
        BaseRespDto baseStudentRespDto = BaseRespDto.builder().result(resultDto).data(studentRespDtos).build();
        log.info("组装返回报文成功！");

        return baseStudentRespDto;
    }

    @GetMapping("/v2/{pageNum}/{pageSize}")
    public BaseRespDto<List<StudentRespDto>> getStudents2(@PathVariable Integer pageNum, @PathVariable Integer pageSize, @PathParam(value = "sortValue") String sortValue,
                                                          @PathParam(value = "schoolCode") String schoolCode, @PathParam(value = "simpleName") String simpleName) {

        List<Student> studentList = studentService.findAllStudent2(pageNum,pageSize,sortValue,schoolCode,simpleName);

        log.info("开始组装返回报文");
        List<StudentRespDto> studentRespDtos = new ArrayList<StudentRespDto>();
        if (studentList != null && studentList.size() > 0) {
            for (Student s : studentList) {
                StudentRespDto studentRespDto = StudentMapper.MAPPER.studentToStudentRespDto(s);
                studentRespDtos.add(studentRespDto);
            }
        }

        ResultDto resultDto = ResultDto.builder().httpStatus(HttpStatus.OK.value()).msg("").build();
        BaseRespDto baseStudentRespDto = BaseRespDto.builder().result(resultDto).data(studentRespDtos).build();
        log.info("组装返回报文成功！");

        return baseStudentRespDto;
    }
}
