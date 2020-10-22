package com.bi.cloud.web.config;

import com.alibaba.fastjson.JSON;
import com.fbi.cloud.api.util.HttpStatusEnum;
import com.fbi.cloud.api.util.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 匿名用户访问无权限资源时的异常
 *
 * @author cy
 * @version CustomizeAuthenticationEntryPoint.java, v 0.1 2020年10月21日 20:10 cy Exp $
 */
@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e)
            throws IOException, ServletException {
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(Result.fail(HttpStatusEnum.LOGIN_FAILURE, HttpStatusEnum.LOGIN_FAILURE.reasonPhraseCN())));

    }
}
