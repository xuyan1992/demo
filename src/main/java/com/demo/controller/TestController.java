package com.demo.controller;


import com.demo.dto.response.ResultDto;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by Administrator on 2019/2/14.
 */
@RestController
@Api("这是一个测试控制器的描述")
@RequestMapping("/test")
public class TestController {

    private static final Logger log= LoggerFactory.getLogger(TestController.class);

    @Value("${com.demo.test.no}")
    private String no;

    @Value("${com.demo.test.name}")
    private String name;

    @ApiOperation(value = "测试接口",notes = "测试接口描述")
    @RequestMapping(value = "/s", method = RequestMethod.GET)
    public String getTestString() {
        log.info("no: " + no + "; name: " + name);
        return "no: " + no + "; name: " + name;
    }

    @ApiOperation(value="测试接口", notes="测试接口描述")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "no", value = "用户no", required = true, dataType = "Long", paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求完成"),
            @ApiResponse(code = 400, message = "请求参数错误")
    })
    @RequestMapping(path = "/index/{id}?no={no}", method = RequestMethod.GET)
    public String index1(@PathVariable("id") String id, @PathParam("no") String no) {
        return "pet";
    }

    @RequestMapping(path = "/result", method = RequestMethod.GET)
    public ResultDto result(){
        ResultDto resultDto = ResultDto.builder().httpStatus(200).build();
        return resultDto;
    }
}
