package com.fbi.cloud.api.service;

import com.fbi.cloud.api.dto.SecurityGroupDTO;
import com.fbi.cloud.api.util.Result;
import com.fbi.cloud.api.vo.SecurityVO;

import java.util.List;

/**
 *
 *
 * @author cy
 * @version SecurityService.java, v 0.1 2020年10月21日 15:04 cy Exp $
 */
public interface SecurityService {

    /**
     * 创建或更新权限
     * @param securityVO
     * @return
     */
    Result insertOrUpdate(SecurityVO securityVO);

    /**
     * 查询权限信息
     * @param id
     * @return
     */
    Result findById(Long id);

    /**
     * 删除权限信息
     * @param id
     * @return
     */
    Result deleteById(Long id);

    /**
     * 通过登陆用户查询权限组
     * @param userLoginId
     * @return
     */
    Result findListByUserLoginId(Long userLoginId);

    /**
     * 通过登陆用户查询权限组
     * @param userLoginCode
     * @return
     */
    List<SecurityGroupDTO> findListByUserLoginCode(String userLoginCode);
}
