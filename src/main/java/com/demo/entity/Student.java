package com.demo.entity;

import com.demo.enums.Gender;
import com.fasterxml.jackson.databind.deser.Deserializers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2019/2/18.
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student extends BaseEntity{
    // 类序列号
    private static final long serialVersionUID = 1L;

    @Column(name = "STUDENT_NO", nullable = false ,unique = true)
    private String studentNo;

    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @Column(name = "SIMPLE_NAME")
    private String simpleName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "AGE")
    private String age;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDAY")
    private Date birthDay;

    @ManyToOne
    @JoinColumn(name = "CLAZZ_ID",nullable = false)
    private Clazz clazz;

}
