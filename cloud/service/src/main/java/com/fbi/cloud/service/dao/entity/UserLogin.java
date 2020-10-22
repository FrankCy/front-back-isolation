package com.fbi.cloud.service.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author cy
 * @version UserLogin.java, v 0.1 2020年10月21日 13:15 cy Exp $
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_login")
@DynamicInsert
@DynamicUpdate
public class UserLogin implements Serializable {

    private static final long serialVersionUID = -5093017447889411442L;

    /**
     * 索引主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '主键'")
    private Long id;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create", columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    @CreatedDate
    private Date gmtCreate;

    /**
     * 最后修改时间
     */
    @Column(name = "gmt_modified",
            columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间'")
    @LastModifiedDate
    private Date gmtModified;

    /**
     * 绑定的用户ID
     */
    @Column(name = "user_id", columnDefinition = "BIGINT(20) NOT NULL  COMMENT '一个用户可以有多个登陆账号'")
    private Long userId;

    /**
     * 登陆账号
     */
    @Column(name = "user_login_code", columnDefinition = "VARCHAR(20) NOT NULL  COMMENT '用户登陆账号'")
    private String userLoginCode;

    /**
     * 登陆密码
     */
    @Column(name = "pass_wd", columnDefinition = "VARCHAR(256) NOT NULL  COMMENT '密码'")
    private String passwd;

    /**
     * 最后登陆时间
     */
    @Column(name = "last_login_time", columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后登陆时间'")
    private Date lastLoginTime;

    /**
     * 创建者的用户ID
     */
    @Column(name = "creator", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '创建者的用户ID'")
    private Long creator;

    /**
     * 最后修改者的用户ID
     */
    @Column(name = "modifier", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '最后修改者的用户ID'")
    private Long modifier;

    /**
     * 状态值，0表示已删除，1表示正常
     */
    @Column(name = "status", columnDefinition = "TINYINT(4) NOT NULL DEFAULT 1 COMMENT '状态值，0表示已删除，1表示正常'")
    private Integer status;

}
