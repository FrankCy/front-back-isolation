package com.fbi.cloud.service.impl;

import com.fbi.cloud.api.service.UserService;
import com.fbi.cloud.api.util.Result;
import com.fbi.cloud.api.vo.UserVO;
import com.fbi.cloud.service.dao.entity.User;
import com.fbi.cloud.service.dao.repository.UserRepository;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Random;

/**
 *
 *
 * @author cy
 * @version UserServiceImpl.java, v 0.1 2020年10月21日 15:04 cy Exp $
 */
@Service(version = "1.0")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Result insertOrUpdate(UserVO userVO) {
        User user = new User();
        BeanUtils.copyProperties(userVO, user);
        user.setCreator(1L);
        user.setModifier(1L);
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        user.setUserCode(String.valueOf(getVerification()));
        return Result.success(userRepository.save(user));
    }

    @Override
    public Result findById(Long id) {
        return null;
    }

    @Override
    public Result deleteById(Long id) {
        return null;
    }


    /**
     *
     * @return
     */
    public static Integer getVerification() {
        Random r = new Random();
        int a = 0;
        for (int i = 0; i < 10; i++) {
            // 第二种方法
            a = r.nextInt(50000) + 1;
            if(a > 0) {
                break;
            }
        }
        return a;
    }
}
