package com.yxp.eguodu.dao.basemsg;

import com.yxp.eguodu.common.queryparams.TeacherQueryParams;
import com.yxp.eguodu.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;




@Mapper
public interface TeacherMapper {
    @Select("<script> " +
            "select teacherId, teacherPaperId,teacherName,t.tel,t.address,ifnull(t.teacherDutyId,'') as teacherDutyId , ifnull(d.teacherDutyName,'') as teacherDutyName\n" +
            "     , d.master, t.schoolId , s.schoolName ,inviteCode from teacher t " +
            "left outer join dic_teacherduty d on t.teacherDutyId=d.teacherDutyId\n" +
            "left outer join school s on t.schoolId=s.schoolId " +
            "where 1=1 and endTime is  null " +
            "<if test='teacherId != null and teacherId !=\"\"'>" +
            " and teacherId like '%${teacherId}%'" +
            "</if>" +
            "<if test='teacherPaperId != null and teacherPaperId !=\"\"'>" +
            " and teacherPaperId like '%${teacherPaperId}%'" +
            "</if>" +
            "<if test='teacherName != null and teacherName !=\"\"'>" +
            " and teacherName like '%${teacherName}%'" +
            "</if>" +
            "<if test='schoolId != null and schoolId !=\"\"'>" +
            " and t.schoolId = '${schoolId}'" +
            "</if>" +
            "<if test='schoolName != null and schoolName !=\"\"'>" +
            " and s.schoolName like '%${schoolName}%'" +
            "</if>" +
            "<if test='schoolName != null and schoolName !=\"\"'>" +
            " and t.teacherDutyId = '${teacherDutyId}'" +
            "</if>" +
            " limit ${pageBegin},${pageSize}" +
            "</script>")
    public List<Map<String,Object>> teacherList(TeacherQueryParams paras);



    @Select("<script>" +
            "  select  teacherId, teacherPaperId,  t.tel, teacherName,  t.teacherDutyId,  d.teacherDutyName,  d.master ,  t.address,  t.schoolId," +
            "   s.schoolName from teacher t inner join school s on t.schoolId=s.schoolId left outer join dic_teacherduty d " +
            "  on t.teacherDutyId=d.teacherDutyId " +
            "where t.wxcode like '%${openId}%'" +
            "</script>")
    public List<Teacher> teacherListByOpenId(@Param("openId") String openId);




    @Select("<script> " +
            "select count(*) as total from teacher t " +
            "left outer join dic_teacherduty d on t.teacherDutyId=d.teacherDutyId\n" +
            "left outer join school s on t.schoolId=s.schoolId " +
            "where 1=1 and endTime is not null " +
            "<if test='teacherId != null and teacherId !=\"\"'>" +
            " and teacherId like '%${teacherId}%'" +
            "</if>" +
            "<if test='teacherPaperId != null and teacherPaperId !=\"\"'>" +
            " and teacherPaperId like '%${teacherPaperId}%'" +
            "</if>" +
            "<if test='teacherName != null and teacherName !=\"\"'>" +
            " and teacherName like '%${teacherName}%' " +
            "</if>" +
            "<if test='schoolId != null and schoolId !=\"\"'>" +
            " and t.schoolId = '${schoolId}'" +
            "</if>" +
            "<if test='schoolName != null and schoolName !=\"\"'>" +
            " and s.schoolName like '%${schoolName}%'" +
            "</if>" +
            "<if test='schoolName != null and schoolName !=\"\"'>" +
            " and t.teacherDutyId = '${teacherDutyId}'" +
            "</if>" +
            " limit ${pageBegin},${pageSize}" +
            "</script>")
    public List<Map<String,Object>> teacherListTotal(TeacherQueryParams paras);

    @Insert({"<script>" +
            "  insert into teacher(teacherId,teacherPaperId,teacherName,tel,address,teacherDutyId,schoolId,regTime,inviteCode)" +
            "  values( func_makeBusinessId('teacher','${schoolId}'), '${teacherPaperId}','${teacherName}','${tel}','${address}'," +
            "         '${teacherDutyId}','${schoolId}',now(), func_makeInviteCode(6,'teacher'))" +
            "</script>" } )
    public int insertTeacher(Teacher teacher);




    @Select ("<script>" +
            "   select teacherId,teacherPaperId,teacherName,tel,address,teacherDutyId,schoolId from " +
            "   teacher where schoolId='${schoolId}' and  tel not in (select account from user where schoolId='${schoolId}') " +
            "</script>")
    public List<Teacher> teacherNoInUser(Map<String,Object> paras);


    /**
     * 批量导入教师信息
     * 1.删除原有老师，
     * 2.删除user表老师用户
     * 3.批量插入
     * 4.批量插入user表
     * @return
     */
    @Delete("delete from teacher where schoolId='${schoolId}'")
    public int deleteAllSchoolTeacher(Map<String,Object> paras);

    @Insert("<script>" +
            "  insert into teacher(teacherId,teacherPaperId,teacherName,tel,address,teacherDutyId,schoolId,regTime,inviteCode) values" +
            " <foreach collection =\"list\" item=\"t\" separator =\",\" >" +
            " ( func_makeBusinessId('teacher','${t.schoolId}'),'${t.teacherPaperId}','${t.teacherName}','${t.tel}','${t.address}'," +
            "   '${t.teacherDutyId}','${t.schoolId}',now(), func_makeInviteCode(6,'teacher')) " +
            "</foreach>" +
            "</script>")
    public int groupInsertTeacher(List<Teacher> teachers);






    @Update("<script>" +
            " update teacher set teacherPaperId='${teacherPaperId}',teacherName='${teacherName}',tel='${tel}'," +
            " address='${address}',teacherDutyId='${teacherDutyId}',schoolId='${schoolId}' " +
            " where teacherId=${teacherId}" +
            "</script>")
    public int updateTeacher(Teacher teacher);
    @Delete("<script>" +
            " delete from teacher where teacherId=${teacherId}" +
            "</script>")
    public int deleteTeacher(Map<String,Object> paras);


    @Update("<script>" +
            " update teacher set endTime= now() where teacherId='${teacherId}'" +
            "</script>")
    public int quitDuty(Map<String,Object> paras);



}
