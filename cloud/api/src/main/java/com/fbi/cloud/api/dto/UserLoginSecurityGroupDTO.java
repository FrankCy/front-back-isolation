package com.fbi.cloud.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 *
 * @author cy
 * @version UserLoginSecurityGroupDTO.java, v 0.1 2020年10月21日 17:16 cy Exp $
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginSecurityGroupDTO implements Serializable {

    private static final long serialVersionUID = -4606249079111745932L;

    /**
     * 用户权限组主键
     */
    private Integer id;



}
