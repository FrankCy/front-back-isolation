package com.fbi.cloud.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author cy
 * @version UserLoginDTO.java, v 0.1 2020年10月21日 17:13 cy Exp $
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO implements Serializable {

    private static final long serialVersionUID = -8775881823923233233L;

    /**
     * 索引主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     */
    private Date gmtModified;

    /**
     * 绑定的用户ID
     */
    private Long userId;

    /**
     * 登陆账号
     */
    private String userLoginCode;

    /**
     * 登陆密码
     */
    private String passwd;

    /**
     * 最后登陆时间
     */
    private Date lastLoginTime;

    /**
     * 创建者的用户ID
     */
    private Long creator;

    /**
     * 最后修改者的用户ID
     */
    private Long modifier;

    /**
     * 状态值，0表示已删除，1表示正常
     */
    private Integer status;

}
