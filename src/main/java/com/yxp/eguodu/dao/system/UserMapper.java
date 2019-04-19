package com.yxp.eguodu.dao.system;

import com.yxp.eguodu.common.queryparams.UserQueryParams;
import com.yxp.eguodu.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("select userId,account,passWord,schoolId,employeeId,teacherPaperId,supperAdmin,schoolAdmin,addTime,kind from user" +
            "  where account ='${account}' and passWord='${passWord}'")
    public List<User> validateUser(User user);



    @Select("<script>" +
            "select userId,account,ifnull(u.schoolId,'') as schoolId, ifnull(s.schoolName,'') as schoolName," +
            "ifnull(u.employeeId,'') as employeeId , ifnull(e.employeeName,'') as employeeName," +
            "ifnull(u.teacherPaperId,'') as teacherPaperId , ifnull(t.teacherName,'') as teacherName, supperAdmin,schoolAdmin," +
            " addTime,kind  from user u" +
            " left outer join school s on  u.schoolId =s.schoolId" +
            " left outer join employee e on u.employeeId =e.employeeId " +
            " left outer join teacher t on t.schoolId =u.schoolId and t.paperId=u.teacherPaperId" +
            " where supperAdmin !=1 " +
            " <if test ='schoolId !=null and schoolId != \"\" and schoolId !=0'>" +
            "   and u.schoolId='${schoolId}'" +
            " </if>" +
            " <if test ='account !=null and account != \"\" '>" +
            "   and u.account like '%${account}%'" +
            " </if>" +
            " <if test ='employeeName !=null and employeeName != \"\" '>" +
            "   and e.employeeName like '%${employeeName}%'" +
            " </if>" +
            " <if test ='teacherName !=null and teacherName != \"\" '>" +
            "   and t.teacherName like '%${teacherName}%'" +
            " </if>" +
            " <if test ='schoolAdmin !=null and schoolAdmin != \"\" '>" +
            "   and schoolAdmin =${schoolAdmin}" +
            " </if>" +
            " <if test ='kind !=null and kind != \"\" '>" +
            "   and kind =${kind}" +
            " </if>" +
            "  limit ${pageBegin},${pageSize}" +
            " </script>")
    public List<Map<String,Object>> userList(UserQueryParams queryParams);



    @Select("<script>" +
            "select count(*) as total  from user u" +
            " left outer join school s on  u.schoolId =s.schoolId" +
            " left outer join employee e on u.employeeId =e.employeeId " +
            " left outer join teacher t on t.schoolId =u.schoolId and t.paperId=u.teacherPaperId" +
            " where supperAdmin !=1 " +
            " <if test ='schoolId !=null and schoolId != \"\" and schoolId !=0'>" +
            "   and u.schoolId='${schoolId}'" +
            " </if>" +
            " <if test ='account !=null and account != \"\" '>" +
            "   and u.account like '%${account}%'" +
            " </if>" +
            " <if test ='employeeName !=null and employeeName != \"\" '>" +
            "   and e.employeeName like '%${employeeName}%'" +
            " </if>" +
            " <if test ='teacherName !=null and teacherName != \"\" '>" +
            "   and t.teacherName like '%${teacherName}%'" +
            " </if>" +
            " <if test ='schoolAdmin !=null and schoolAdmin != \"\" '>" +
            "   and schoolAdmin =${schoolAdmin}" +
            " </if>" +
            " <if test ='kind !=null and kind != \"\" '>" +
            "   and kind =${kind}" +
            " </if>" +
            " </script>")
    public List<Map<String,Object>> userListTotal(UserQueryParams queryParams);




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
