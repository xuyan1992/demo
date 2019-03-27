package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Administrator on 2019/2/18.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Grade extends BaseEntity{
    // 类序列号
    private static final long serialVersionUID = 1L;

    @Column(name = "GRADE_CODE",nullable = false, unique = true)
    private String gradeCode;

    @Column(name = "GRADE_NAME")
    private String gradeName;

}
