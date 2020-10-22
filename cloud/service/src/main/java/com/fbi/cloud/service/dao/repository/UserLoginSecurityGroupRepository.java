package com.fbi.cloud.service.dao.repository;

import com.fbi.cloud.service.dao.entity.UserLoginSecurityGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 *
 * @author cy
 * @version UserLoginSecurityGroupRepository.java, v 0.1 2020年10月21日 14:59 cy Exp $
 */
public interface UserLoginSecurityGroupRepository extends JpaRepository<UserLoginSecurityGroup, Long>,
        JpaSpecificationExecutor<UserLoginSecurityGroup> {

    /**
     * 根据登陆人Id，查询有效的权限组
     * @param status
     * @param userId
     * @return
     */
    @Query(value = "select id, security_permission_group_id, user_login_id, gmt_create, gmt_modified, status "
            + "from user_login_security_group ulsg   "
            + "where ulsg.status = ?1 "
            + "and ulsg.user_login_id = ?2 "
            , nativeQuery = true)
    List<UserLoginSecurityGroup> findAllByStatusAndUserLoginId(Long status, Long userId);

    /**
     * 根据登陆人Code，查询有效的权限组
     * @param status
     * @param userLoginCode
     * @return
     */
    @Query(value = "select id, security_permission_group_id, user_login_id, gmt_create, gmt_modified, status "
            + "from user_login_security_group ulsg   "
            + "where ulsg.status = ?1 "
            + "and ulsg.user_login_code = ?2 "
            , nativeQuery = true)
    List<UserLoginSecurityGroup> findAllByStatusAndUserLoginCode(Long status, String userLoginCode);

}