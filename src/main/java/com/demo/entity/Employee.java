package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Administrator on 2019/2/15.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Employee implements Serializable {

    // 类序列号
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String age;
}
