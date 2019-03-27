package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 学校
 * Created by Administrator on 2019/2/15.
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class School extends BaseEntity{
    // 类序列号
    private static final long serialVersionUID = 1L;

    @Column(name = "SCHOOL_CODE",nullable = false, unique = true)
    private String schoolCode;

    @Column(name = "SCHOOL_NAME")
    private String schoolName;
}
