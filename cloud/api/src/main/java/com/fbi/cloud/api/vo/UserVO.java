package com.fbi.cloud.api.vo;

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
 * @version UserVO.java, v 0.1 2020年10月21日 15:06 cy Exp $
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO implements Serializable {

    private static final long serialVersionUID = 5591274790433689683L;

    /**
     * 状态 0：不正常；1：正常
     */
    private Integer status;

    /**
     * 用户名
     */
    private String userName;


}
