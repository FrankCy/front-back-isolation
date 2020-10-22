package com.fbi.cloud.service.dao.repository;

import com.fbi.cloud.service.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 *
 * @author cy
 * @version UserRepository.java, v 0.1 2020年10月21日 11:57 cy Exp $
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}