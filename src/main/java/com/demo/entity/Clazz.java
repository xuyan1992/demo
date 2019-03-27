package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Administrator on 2019/2/22.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Clazz extends BaseEntity{
    // 类序列号
    private static final long serialVersionUID = 1L;

    @Column(name = "CLAZZ_CODE", nullable = false , unique = true)
    private String clazzCode;

    @Column(name = "CLAZZ_NAME")
    private String clazzName;

    @ManyToOne
    @JoinColumn(name = "GRADE_ID", nullable = false)
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "SCHOOL_ID", nullable = false)
    private School school;

}
