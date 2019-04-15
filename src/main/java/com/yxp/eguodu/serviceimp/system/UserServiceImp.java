package com.yxp.eguodu.serviceimp.system;

import com.yxp.eguodu.common.DesUtil;
import com.yxp.eguodu.common.queryparams.UserQueryParams;
import com.yxp.eguodu.dao.system.UserMapper;
import com.yxp.eguodu.entity.User;
import com.yxp.eguodu.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper mapper;
    @Override
    public List<User> validateUser(User user) throws Exception {
        user.setPassWord(DesUtil.encrypt(user.getPassWord()));
        return mapper.validateUser(user);
    }

    @Override
    public List<Map<String, Object>> userList(UserQueryParams queryParams) {
        return mapper.userList(queryParams);
    }

    @Override
    public List<Map<String, Object>> userListTotal(UserQueryParams queryParams) {
        return mapper.userListTotal(queryParams);
    }

    @Override
    public int insertUser(User user) {
        return mapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return mapper.updateUser(user);
    }

    @Override
    public int changePwd(User user) {
        return mapper.changePwd(user);
    }


}
