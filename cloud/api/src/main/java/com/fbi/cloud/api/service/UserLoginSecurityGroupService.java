package com.fbi.cloud.api.service;

import com.fbi.cloud.api.dto.UserLoginSecurityGroupDTO;

import java.util.List;

/**
 *
 *
 * @author cy
 * @version UserLoginSecurityGroupService.java, v 0.1 2020年10月21日 17:12 cy Exp $
 */
public interface UserLoginSecurityGroupService {

    /**
     * 查询当前登陆用户安全组信息
     * @param userLoginId
     * @return
     */
    List<UserLoginSecurityGroupDTO> findListByUserLoginId(Long userLoginId);

    /**
     * 查询当前登陆用户安全组信息
     * @param userLoginCode
     * @return
     */
    List<UserLoginSecurityGroupDTO> findListByUserLoginCode(String userLoginCode);

}
