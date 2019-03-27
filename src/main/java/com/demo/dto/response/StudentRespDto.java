package com.demo.dto.response;

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
public class StudentRespDto {

    private String studentNo;
    private String userName;
    private String simpleName;
    private String password;
    private String gender;
    private String age;
    private ClazzRespDto clazz;
}
