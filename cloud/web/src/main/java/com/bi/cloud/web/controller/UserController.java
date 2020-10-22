package com.bi.cloud.web.controller;

import com.fbi.cloud.api.service.UserService;
import com.fbi.cloud.api.util.Result;
import com.fbi.cloud.api.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 *
 * @author cy
 * @version UserController.java, v 0.1 2020年10月21日 15:49 cy Exp $
 */
@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Reference(version = "1.0", check = false, timeout = 50000, retries = -1)
    private UserService userService;

    /**
     * 新增用户
     * @return
     */
    @RequestMapping(value = "/insert")
    @ResponseBody
    public Result putFile(UserVO userVO) {
        return userService.insertOrUpdate(userVO);
    }

}
