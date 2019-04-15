package com.yxp.eguodu.dao.system;

import com.yxp.eguodu.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("select userId,account,passWord,schoolId,employeePaperId,teacherPaperId,supperAdmin,schoolAdmin,addTime,kind from user" +
            "  where account ='${account}' and passWord='${passWord}'")
    public List<User> validateUser(User user);

    @Select("select userId,account,passWord,schoolId,employeePaperId,teacherPaperId,supperAdmin,schoolAdmin,addTime,kind from user" +
            "  where 1=1" +
            " ")
    public List<Map<String,Object>> userList(Map<String,Object> paras);


    @Insert("<script>" +
            " insert into user(userId,account,passWord,schoolId,employeePaperId,teacherPaperId,supperAdmin,schoolAdmin,addTime,kind)" +
            " values ('${userId}','${account}','${passWord}','${schoolId}','${employeePaperId}','${teacherPaperId}'," +
            " ${supperAdmin},${schoolAdmin},now(),${kind}) " +
            "</script>")
    public int insertUser(User user);

    @Update("<script>" +
            " update user set account=account where userId='${userId}'" +
            "</script>")
    public int updateUser(User user);
    @Update("<script>" +
            " update user set passWord='${passWord}' where userId='${userId}'" +
            "</script>")
    public int changePwd(User user);
}
