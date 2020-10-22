package com.fbi.cloud.service.dao.repository;

import com.fbi.cloud.service.dao.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 *
 * @author cy
 * @version UserLoginRepository.java, v 0.1 2020年10月21日 14:58 cy Exp $
 */
public interface UserLoginRepository extends JpaRepository<UserLogin, Long>, JpaSpecificationExecutor<UserLogin> {

    /**
     * 根据登陆用户查询用户信息
     * @param userLoginCode
     * @return
     */
    UserLogin findByUserLoginCode(String userLoginCode);

    /**
     * 根据状态查看用户登陆信息
     * @param status
     * @return
     */
    @Query(value = "select id, creator, gmt_create, gmt_modified, last_login_time, user_id, modifier, pass_wd, status, user_login_code "
            + "from user_login ul   "
            + "where ul.status = ?1 "
            , nativeQuery = true)
    List<UserLogin> getAllByStatusAndUserId(int status, Long userId);

}