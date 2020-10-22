package com.fbi.cloud.service.dao.pkconfig;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 *
 * @author cy
 * @version UserLoginSecurityGroupPK.java, v 0.1 2020年10月21日 15:21 cy Exp $
 */
@Getter
@Setter
public class UserLoginSecurityGroupPK implements Serializable {

    private static final long serialVersionUID = 2716862360033809491L;

    /**
     * ID
     */
    private Long id;

    /**
     * 用户登陆ID
     */
    private Long userLoginId;

    /**
     * 安全组ID
     */
    private Long securityGroupId;

}

