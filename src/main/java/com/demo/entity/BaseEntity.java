package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/2/18.
 */

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
//JPA Audit 在spring jpa中，支持在字段或者方法上进行注解@CreatedDate、@CreatedBy、@LastModifiedDate、@LastModifiedBy需要在类上加上注解@EntityListeners(AuditingEntityListener.class)，其次在application启动类中加上注解EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    // 类序列号
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Version
    @Column(name = "VERSION")
    private Long version = 1L;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME")
    private Date creatTime;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_TIME")
    private Date updateTime;


}
