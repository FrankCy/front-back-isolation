package com.bi.cloud.web.config;

import com.alibaba.fastjson.JSON;
import com.fbi.cloud.api.dto.UserLoginDTO;
import com.fbi.cloud.api.service.UserLoginService;
import com.fbi.cloud.api.util.Result;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 *
 * 登陆成功
 *
 * @author cy
 * @version CustomizeAuthenticationSuccessHandler.java, v 0.1 2020年10月21日 20:33 cy Exp $
 */
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Reference(version = "1.0", check = false, timeout = 50000, retries = -1)
    private UserLoginService userLoginService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws
            IOException, ServletException {
        // 更新用户登陆信息
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserLoginDTO userLoginDTO = userLoginService.findByUserLoginCode(userDetails.getUsername());
        // 最后一次登陆时间
        userLoginDTO.setLastLoginTime(new Date());
        // 最后修改时间
        userLoginDTO.setGmtModified(new Date());
        // 最后修改人
        userLoginDTO.setModifier(userLoginDTO.getId());
        userLoginService.insertOrUpdate(userLoginDTO);

        // 登陆成功，读取当前登陆用户可访问菜单


        //返回json数据
        Result result = Result.success();
        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("text/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}

