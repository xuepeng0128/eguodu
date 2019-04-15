package com.yxp.eguodu.serviceimp.system;

import com.yxp.eguodu.common.DesUtil;
import com.yxp.eguodu.dao.system.UserMapper;
import com.yxp.eguodu.entity.User;
import com.yxp.eguodu.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper mapper;
    @Override
    public List<User> validateUser(User user) throws Exception {
        user.setPassWord(DesUtil.encrypt(user.getPassWord()));
        return mapper.validateUser(user);
    }
}
