package com.bi.cloud.web.config;

import com.alibaba.fastjson.JSON;
import com.fbi.cloud.api.util.HttpStatusEnum;
import com.fbi.cloud.api.util.Result;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *
 * @author cy
 * @version CustomizeSessionInformationExpiredStrategy.java, v 0.1 2020年10月21日 23:06 cy Exp $
 */
@Component
public class CustomizeSessionInformationExpiredStrategy  implements SessionInformationExpiredStrategy {

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException,
            ServletException {
        HttpServletResponse httpServletResponse = sessionInformationExpiredEvent.getResponse();
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(Result.fail(HttpStatusEnum.USER_CREDENTIALS_EXPIRED, HttpStatusEnum.USER_CREDENTIALS_EXPIRED.reasonPhraseCN())));
    }
}