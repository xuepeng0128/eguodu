package com.yxp.eguodu.service.system;

import com.yxp.eguodu.common.queryparams.UserQueryParams;
import com.yxp.eguodu.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> validateUser(User user) throws Exception;

    public List<Map<String,Object>> userList(UserQueryParams queryParams);
    public List<Map<String,Object>> userListTotal(UserQueryParams queryParams);
    public int insertUser(User user);
    public int updateUser(User user);
    public int groupInsertUser(List<User> users);
    public int changePwd(User user);
    public int deleteUser(Map<String,Object> paras);
    public int deleteUserByTeacherId(Map<String,Object> paras);

}
