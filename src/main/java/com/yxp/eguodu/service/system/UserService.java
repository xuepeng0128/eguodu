package com.yxp.eguodu.service.system;

import com.yxp.eguodu.entity.User;

import java.util.List;

public interface UserService {
    public List<User> validateUser(User user) throws Exception;
}
