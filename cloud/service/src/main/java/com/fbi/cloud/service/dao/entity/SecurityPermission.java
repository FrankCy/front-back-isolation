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
 * 权限表
 *
 * @author cy
 * @version security_permission.java, v 0.1 2020年10月21日 13:36 cy Exp $
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "security_permission")
@DynamicInsert
@DynamicUpdate
public class SecurityPermission implements Serializable {

    private static final long serialVersionUID = 3798304167571389372L;

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
     * 权限编码（用于判断使用）
     */
    @Column(name = "security_permission_code", columnDefinition = "VARCHAR(20) COMMENT '权限编码'")
    private String securityPermissionCode;

    /**
     * 权限类型
     */
    @Column(name = "security_permission_type_id", columnDefinition = "BIGINT(20) NOT NULL DEFAULT 1 COMMENT '类型自定义，例如（system、support_system、button、path等）'")
    private Long securityPermissionTypeId;

    /**
     * 上级权限ID
     */
    @Column(name = "parent_security_permission_id", columnDefinition = "BIGINT(20) COMMENT '上级权限ID'")
    private Long parentSecurityPermissionId;

    /**
     * 权限级别
     */
    @Column(name = "security_permission_level", columnDefinition = "VARCHAR(20) COMMENT '权限级别'")
    private String securityPermissionLevel;

    /**
     * 描述
     */
    @Column(name = "description", columnDefinition = "VARCHAR(128) COMMENT '描述'")
    private String description;

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
