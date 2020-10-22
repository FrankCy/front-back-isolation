package com.fbi.cloud.service.impl;

import com.fbi.cloud.api.dto.UserLoginDTO;
import com.fbi.cloud.api.service.UserLoginService;
import com.fbi.cloud.api.util.Result;
import com.fbi.cloud.service.dao.entity.UserLogin;
import com.fbi.cloud.service.dao.repository.UserLoginRepository;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 *
 * @author cy
 * @version UserLoginServiceImpl.java, v 0.1 2020年10月21日 15:04 cy Exp $
 */
@Service(version = "1.0")
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public void insertOrUpdate(UserLoginDTO userLoginDTO) {
        UserLogin userLogin = new UserLogin();
        BeanUtils.copyProperties(userLoginDTO, userLogin);
        userLoginRepository.save(userLogin);
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
    public UserLoginDTO findByEnabled(String userLoginCode) {
        return null;
    }

    @Override
    public UserLoginDTO findByUserLoginCode(String userLoginCode) {
        UserLogin userLogin = userLoginRepository.findByUserLoginCode(userLoginCode);
        if(userLogin != null) {
            UserLoginDTO userLoginDTO = new UserLoginDTO();
            BeanUtils.copyProperties(userLogin, userLoginDTO);
            return userLoginDTO;
        }
        return null;
    }
}
