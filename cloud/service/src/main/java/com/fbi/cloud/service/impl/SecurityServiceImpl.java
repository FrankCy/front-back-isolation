package com.fbi.cloud.service.impl;

import com.fbi.cloud.api.dto.SecurityGroupDTO;
import com.fbi.cloud.api.service.SecurityService;
import com.fbi.cloud.api.util.Result;
import com.fbi.cloud.api.vo.SecurityVO;
import com.fbi.cloud.service.dao.entity.SecurityGroup;
import com.fbi.cloud.service.dao.repository.SecurityGroupRepository;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author cy
 * @version SecurityServiceImpl.java, v 0.1 2020年10月21日 15:04 cy Exp $
 */
@Service(version = "1.0")
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private SecurityGroupRepository securityGroupRepository;

    @Override
    public Result insertOrUpdate(SecurityVO securityVO) {
        return null;
    }

    @Override
    public Result findById(Long id) {
        return null;
    }

    @Override
    public Result deleteById(Long id) {
        return null;
    }

    @Override
    public Result findListByUserLoginId(Long userLoginId) {
        List<SecurityGroup> securityGroupList = securityGroupRepository.findAllByUserLoginId(1L, userLoginId);
        if(securityGroupList.size() > 0) {
            return Result.success(securityGroupList);
        }
        return null;
    }

    @Override
    public List<SecurityGroupDTO> findListByUserLoginCode(String userLoginCode) {
        List<SecurityGroup> securityGroupList = securityGroupRepository.findAllByUserLoginCode(1L, userLoginCode);
        if(securityGroupList.size() > 0) {
            List<SecurityGroupDTO> securityGroupDTOS = new ArrayList<>();
            for(SecurityGroup securityGroup : securityGroupList) {
                SecurityGroupDTO securityGroupDTO = new SecurityGroupDTO();
                BeanUtils.copyProperties(securityGroup, securityGroupDTO);
                securityGroupDTOS.add(securityGroupDTO);
            }
            return securityGroupDTOS;
        }
        return null;
    }

}
