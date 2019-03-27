package com.demo.dto.response;

import lombok.*;

/**
 * Created by Administrator on 2019/2/20.
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private String name;

    private String age;
}
