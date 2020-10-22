package com.bi.cloud.web.config;

import com.alibaba.fastjson.JSON;
import com.fbi.cloud.api.util.HttpStatusEnum;
import com.fbi.cloud.api.util.Result;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 登陆失败
 *
 * @author cy
 * @version CustomizeAuthenticationFailureHandler.java, v 0.1 2020年10月21日 20:48 cy Exp $
 */
@Component
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws
            IOException, ServletException {
        //返回json数据
        Result result;
        if (e instanceof AccountExpiredException) {
            //账号过期
            result = Result.fail(HttpStatusEnum.USER_ACCOUNT_EXPIRED, HttpStatusEnum.USER_ACCOUNT_EXPIRED.reasonPhraseCN());
        } else if (e instanceof BadCredentialsException) {
            //密码错误
            result = Result.fail(HttpStatusEnum.USER_CREDENTIALS_ERROR, HttpStatusEnum.USER_CREDENTIALS_ERROR.reasonPhraseCN());
        } else if (e instanceof CredentialsExpiredException) {
            //密码过期
            result = Result.fail(HttpStatusEnum.USER_CREDENTIALS_EXPIRED, HttpStatusEnum.USER_CREDENTIALS_EXPIRED.reasonPhraseCN());
        } else if (e instanceof DisabledException) {
            //账号不可用
            result = Result.fail(HttpStatusEnum.USER_ACCOUNT_DISABLE, HttpStatusEnum.USER_ACCOUNT_DISABLE.reasonPhraseCN());
        } else if (e instanceof LockedException) {
            //账号锁定
            result = Result.fail(HttpStatusEnum.USER_ACCOUNT_LOCKED, HttpStatusEnum.USER_ACCOUNT_LOCKED.reasonPhraseCN());
        } else if (e instanceof InternalAuthenticationServiceException) {
            //用户不存在
            result = Result.fail(HttpStatusEnum.USER_ACCOUNT_NOT_EXIST, HttpStatusEnum.USER_ACCOUNT_NOT_EXIST.reasonPhraseCN());
        }else{
            //其他错误
            result = Result.fail(HttpStatusEnum.COMMON_FAIL, HttpStatusEnum.COMMON_FAIL.reasonPhraseCN());
        }
        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("text/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
