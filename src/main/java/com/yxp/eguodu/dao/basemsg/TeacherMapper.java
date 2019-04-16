package com.yxp.eguodu.dao.basemsg;

import com.yxp.eguodu.common.queryparams.TeacherQueryParams;
import com.yxp.eguodu.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;




@Mapper
public interface TeacherMapper {
    @Select("<script> " +
            "select id, paperId,teacherName,tel,address,ifnull(t.teacherDutyId,'') as teacherDutyId , ifnull(d.teacherDutyName,'') as teacherDutyName\n" +
            "     , t.schoolId , s.schoolName from teacher t " +
            "left outer join dic_teacherduty d on t.teacherDutyId=d.teacherDutyId\n" +
            "left outer join school s on t.schoolId=s.schoolId " +
            "where 1=1" +
            "<if test='paperId != null and paperId !=\"\"'>" +
            " and paperId like '%${paperId}%'" +
            "</if>" +
            "<if test='teacherName != null and teacherName !=\"\"'>" +
            " and teacherName like '%${teacherName}'%" +
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


    @Select("<script> " +
            "select count(*) as total from teacher t " +
            "left outer join dic_teacherduty d on t.teacherDutyId=d.teacherDutyId\n" +
            "left outer join school s on t.schoolId=s.schoolId " +
            "where 1=1" +
            "<if test='paperId != null and paperId !=\"\"'>" +
            " and paperId like '%${paperId}%'" +
            "</if>" +
            "<if test='teacherName != null and teacherName !=\"\"'>" +
            " and teacherName like '%${teacherName}'%" +
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

    @Insert("<script>" +
            "  insert into teacher(paperId,teacherName,tel,address,teacherDutyId,schoolId,regTime)" +
            "  values('${paperId}','${teacherName}','${tel}','${address}','${teacherDutyId}','${schoolId}',now())" +
            "</script>")
    public int insertTeacher(Teacher teacher);

    @Insert("<script>" +
            "  insert into teacher(paperId,teacherName,tel,address,teacherDutyId,schoolId,regTime) values" +
            " <foreach collection =\"list\" item=\"t\" separator =\",\" >" +
            " ('${t.paperId}','${t.teacherName}','${t.tel}','${t.address}','${t.teacherDutyId}','${t.schoolId}',now()) " +
            "</foreach>" +
            "</script>")
    public int groupInsertTeacher(List<Teacher> teachers);
    @Update("<script>" +
            " update teacher set paperId='${paperId}',teacherName='${teacherName}',tel='${tel}'," +
            " address='${address}',teacherDutyId='${teacherDutyId}',schoolId='${schoolId}' " +
            " where id=${id}" +
            "</script>")
    public int updateTeacher(Teacher teacher);
    @Delete("<script>" +
            " delete from teacher where id=${id}" +
            "</script>")
    public int deleteTeacher(String id);
}
