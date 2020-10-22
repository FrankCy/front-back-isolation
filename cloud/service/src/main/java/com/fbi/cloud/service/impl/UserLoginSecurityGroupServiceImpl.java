package com.fbi.cloud.service.impl;

import com.fbi.cloud.api.dto.UserLoginSecurityGroupDTO;
import com.fbi.cloud.api.service.UserLoginSecurityGroupService;
import com.fbi.cloud.service.dao.entity.UserLoginSecurityGroup;
import com.fbi.cloud.service.dao.repository.UserLoginSecurityGroupRepository;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author cy
 * @version UserLoginSecurityGroupServiceImpl.java, v 0.1 2020年10月21日 17:22 cy Exp $
 */
@Service(version = "1.0")
public class UserLoginSecurityGroupServiceImpl implements UserLoginSecurityGroupService {

    @Autowired
    private UserLoginSecurityGroupRepository userLoginSecurityGroupRepository;

    @Override
    public List<UserLoginSecurityGroupDTO> findListByUserLoginId(Long userLoginId) {
        List<UserLoginSecurityGroup> userLoginSecurityGroups = userLoginSecurityGroupRepository.findAllByStatusAndUserLoginId(1L, userLoginId);
        if(userLoginSecurityGroups.size() > 0) {
            return initUserLoginSecurityGroupList(userLoginSecurityGroups);
        }
        return null;
    }

    @Override
    public List<UserLoginSecurityGroupDTO> findListByUserLoginCode(String userLoginCode) {
        List<UserLoginSecurityGroup> userLoginSecurityGroups = userLoginSecurityGroupRepository.findAllByStatusAndUserLoginCode(1L, userLoginCode);
        if(userLoginSecurityGroups.size() > 0) {
            return initUserLoginSecurityGroupList(userLoginSecurityGroups);
        }
        return null;
    }

    private List<UserLoginSecurityGroupDTO> initUserLoginSecurityGroupList(List<UserLoginSecurityGroup> userLoginSecurityGroups) {
        List<UserLoginSecurityGroupDTO> userLoginSecurityGroupDTOS = new ArrayList<>();
        for(UserLoginSecurityGroup userLoginSecurityGroup : userLoginSecurityGroups) {
            UserLoginSecurityGroupDTO userLoginSecurityGroupDTO = new UserLoginSecurityGroupDTO();
            BeanUtils.copyProperties(userLoginSecurityGroup, userLoginSecurityGroupDTO);
            userLoginSecurityGroupDTOS.add(userLoginSecurityGroupDTO);
        }
        return userLoginSecurityGroupDTOS;
    }

}