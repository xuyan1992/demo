package com.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/2/21.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentReqDto {

    private String studentNo;
    private String userName;
    private String simpleName;
    private String password;
    private String gender;
    private String age;
    private String birthday;
    private String clazzCode;
}
