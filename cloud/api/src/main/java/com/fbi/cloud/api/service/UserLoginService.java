package com.fbi.cloud.api.service;

import com.fbi.cloud.api.dto.UserLoginDTO;
import com.fbi.cloud.api.util.Result;

/**
 *
 *
 * @author cy
 * @version UserLoginService.java, v 0.1 2020年10月21日 15:03 cy Exp $
 */
public interface UserLoginService {

    /**
     * 创建或更新用户登陆信息
     * @param userLoginDTO
     * @return
     */
    void insertOrUpdate(UserLoginDTO userLoginDTO);

    /**
     * 查询用户登陆信息信息
     * @param id
     * @return
     */
    Result findById(Long id);

    /**
     * 删除用户登陆信息信息
     * @param id
     * @return
     */
    Result deleteById(Long id);

    /**
     * 查询当前登陆账号是否启用
     * @param userLoginCode
     * @return
     */
    UserLoginDTO findByEnabled(String userLoginCode);

    /**
     * 查询当前登陆账号信息
     * @param userLoginCode
     * @return
     */
    UserLoginDTO findByUserLoginCode(String userLoginCode);


}
