package com.fbi.cloud.service.dao.repository;

import com.fbi.cloud.service.dao.entity.SecurityGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 *
 * @author cy
 * @version SecurityGroupRepository.java, v 0.1 2020年10月21日 14:59 cy Exp $
 */
public interface SecurityGroupRepository extends JpaRepository<SecurityGroup, Long>, JpaSpecificationExecutor<SecurityGroup> {

    /**
     * 根据状态查看用户登陆信息
     * @param status
     * @return
     */
    @Query(value = "select sg.id, sg.creator, sg.description, sg.gmt_create, sg.gmt_modified, sg.group_code, sg.group_type_id, sg.modifier, sg.status "
            + "from security_group sg "
            + "left join user_login_security_group ulsg "
            + "on ulsg.security_group_id = sg.id "
            + "and sg.status = ?1 "
            + "where ulsg.user_login_id = ?2 "
            , nativeQuery = true)
    List<SecurityGroup> findAllByUserLoginId(Long status, Long userId);

    /**
     * 根据状态查看用户登陆信息
     * @param status
     * @return
     */
    @Query(value = "select sg.id, sg.creator, sg.description, sg.gmt_create, sg.gmt_modified, sg.group_code, sg.group_type_id, sg.modifier, sg.status "
            + "from security_group sg "
            + "left join user_login_security_group ulsg "
            + "on ulsg.security_group_id = sg.id "
            + "left join user_login ul "
            + "on ul.id = ulsg.user_login_id "
            + "and sg.status = ?1 "
            + "where ul.user_login_code = ?2 "
            , nativeQuery = true)
    List<SecurityGroup> findAllByUserLoginCode(Long status, String userLoginCode);

}