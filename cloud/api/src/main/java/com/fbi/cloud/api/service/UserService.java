package com.fbi.cloud.api.service;

import com.fbi.cloud.api.util.Result;
import com.fbi.cloud.api.vo.UserVO;

/**
 *
 *
 * @author cy
 * @version UserService.java, v 0.1 2020年10月21日 15:03 cy Exp $
 */
public interface UserService {

    /**
     * 创建或更新用户
     * @param userVO
     * @return
     */
    Result insertOrUpdate(UserVO userVO);

    /**
     * 查询用户信息
     * @param id
     * @return
     */
    Result findById(Long id);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    Result deleteById(Long id);

}
