package com.fbi.cloud.service.dao.repository;

import com.fbi.cloud.service.dao.entity.SecurityPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 *
 * @author cy
 * @version SecurityPermissionRepository.java, v 0.1 2020年10月21日 14:59 cy Exp $
 */
public interface SecurityPermissionRepository extends JpaRepository<SecurityPermission, Long>,
        JpaSpecificationExecutor<SecurityPermission> {
}