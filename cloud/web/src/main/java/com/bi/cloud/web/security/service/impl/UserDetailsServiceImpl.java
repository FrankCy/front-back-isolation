package com.bi.cloud.web.security.service.impl;

import com.fbi.cloud.api.dto.SecurityGroupDTO;
import com.fbi.cloud.api.dto.UserLoginDTO;
import com.fbi.cloud.api.service.SecurityService;
import com.fbi.cloud.api.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author cy
 * @version UserDetailServiceImpl.java, v 0.1 2020年10月21日 17:10 cy Exp $
 */
@Service("userDetailsServiceImpl")
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Reference(version = "1.0", check = false, timeout = 50000, retries = -1)
    private UserLoginService userLoginService;

    @Reference(version = "1.0", check = false, timeout = 50000, retries = -1)
    private SecurityService securityService;


    @Override
    public UserDetails loadUserByUsername(String userLoginId) throws UsernameNotFoundException {

        // 获取数据库用户信息
        UserLoginDTO userLoginDTO = userLoginService.findByUserLoginCode(userLoginId);

        if(userLoginDTO == null) {
            throw new RuntimeException("Login error ! 登录失败，无法找到此用户！");
        }

        // 获取数据库安全组信息
        List<SecurityGroupDTO> securityGroupDTOS = securityService.findListByUserLoginCode(userLoginDTO.getUserLoginCode());
        if(securityGroupDTOS != null && securityGroupDTOS.size() > 0) {
            List<String> securityGroupInfoList = new ArrayList<>();
            for(SecurityGroupDTO securityGroupDTO : securityGroupDTOS) {
                securityGroupInfoList.add(securityGroupDTO.getGroupCode());
            }
            // 将信息转换为Detail（权限认证用）
            return changeToUser(userLoginDTO, securityGroupInfoList);
        } else {
            //TODO:调试代码，默认给一个ADMIN权限
            List<String> securityGroupInfoList = new ArrayList<>();
            securityGroupInfoList.add("ADMIN");
            return changeToUser(userLoginDTO, securityGroupInfoList);
        }
    }

    public UserDetails changeToUser(UserLoginDTO userLoginDTO, List<String> securityGroupInfoList) {

        log.info("查询用户信息：{} ", userLoginDTO.toString());

        // 权限列表
        List<GrantedAuthority> authorityList = new ArrayList<>();

        // 赋予查询到的安全组
        for(String securityGroupCode : securityGroupInfoList) {
            GrantedAuthority authority = new SimpleGrantedAuthority(securityGroupCode);
            authorityList.add(authority);
        }
        //GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        //authorityList.add(authority);

        // 创建UserDetails对象，设置用户名、密码和权限
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                userLoginDTO.getUserLoginCode(),
                userLoginDTO.getPasswd(),
                authorityList);

        return userDetails;
    }

}
