package com.fbi.cloud.service.dao.entity;

import com.fbi.cloud.service.dao.pkconfig.SecurityPermissionGroupPK;
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
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * 权限与权限组关系表
 *
 * @author cy
 * @version SecurityPermissionGroup.java, v 0.1 2020年10月21日 14:08 cy Exp $
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "security_permission_group")
@DynamicInsert
@DynamicUpdate
@IdClass(SecurityPermissionGroupPK.class)
public class SecurityPermissionGroup implements Serializable {

    private static final long serialVersionUID = 5050417511106523238L;

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
     * 权限主键
     */
    @Id
    @Column(name = "security_permission_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '权限主键'")
    private Long securityPermissionId;

    /**
     * 权限组主键
     */
    @Id
    @Column(name = "security_group_id", columnDefinition = "BIGINT(20) UNSIGNED NOT NULL COMMENT '权限组主键'")
    private Long securityGroupId;

    /**
     * 状态值，0表示已删除，1表示正常
     */
    @Column(name = "status", columnDefinition = "TINYINT(4) NOT NULL DEFAULT 1 COMMENT '状态值，0表示已删除，1表示正常'")
    private Integer status;

}
