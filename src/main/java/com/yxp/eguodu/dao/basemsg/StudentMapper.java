package com.yxp.eguodu.dao.basemsg;

import com.yxp.eguodu.common.queryparams.StudentQueryParams;
import com.yxp.eguodu.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


@Mapper
public interface StudentMapper {
    @Select("<script>" +
            " select id,studentId, studentPaperId,studentName,s.tel,s.address,s.sex,s.birthday,s.schoolId,c.schoolName," +
            "  l.grade,l.classes,l.classesName ,c.schoolStyle,c.train " +
            " from student s inner join " +
            " school c on s.schoolId=c.schoolId inner JOIN classes l on s.schoolId=l.schoolId" +
            " where  1=1 " +
            " <if test ='studentPaperId != null and studentPaperId !=\"\"'>" +
            "   and paperId like '%${studentPaperId}%'" +
            " </if>" +
            " <if test ='studentName != null and studentName !=\"\"'>" +
            "   and studentName like '%${studentName}%'" +
            " </if>" +
            " <if test ='schoolId != null and schoolId !=\"\" and schoolId !=\"0\" '>" +
            "   and s.schoolId = '${schoolId}'" +
            " </if>" +
            " <if test ='schoolName != null and schoolName !=\"\" '>" +
            "   and s.schoolName like '%${schoolName}%'" +
            " </if>" +
            " limit ${pageBegin} ,${pageSize}" +
            " </script>")
    public List<Map<String,Object>> studentList(StudentQueryParams queryParams);

    @Select("<script>" +
            "   select    id,studentPaperId,studentId,studentName,sex,birthday,t.schoolId, case when s.schoolName is null then t.schoolName else s.schoolName end as schoolName ," +
            "   t.address,t.tel,headimg,nickname," +
            "   t.regTime, wxcode from student t left outer join school s on t.schoolId=s.schoolId " +
            "where t.wxcode like '%${openId}%'" +
            "</script>")
    public List<Student>  studentListByOpenId(@Param("openId") String openId);

    // 绑定学生邀请码
    @Select("<script>" +
            "   select    id,studentPaperId,studentId,studentName,sex,birthday,t.schoolId, case when s.schoolName is null then t.schoolName else s.schoolName end as schoolName ," +
            "   t.address,t.tel,headimg,nickname," +
            "   t.regTime, wxcode from student t left outer join school s on t.schoolId=s.schoolId " +
            "where t.inviteCode = '${inviteCode}'" +
            "</script>")
    public List<Student> studentListByInviteCode(@Param("inviteCode") String inviteCode);


    // 根据绑定成功的邀请码 ，填入openid,headimg,nickname
    @Update("update student set wxcode= concat(ifnull(wxcode,''),'${openId}'), headimg='${headimg}' , nickname='${nickname}' where id= #{id}")
    public int addStudentOpenId(@Param("id") int id,@Param("openId") String openId,@Param("headimg") String headimg,@Param("nickname") String nickname );





    @Select("<script>" +
            " select count(*) as total " +
            " from student s inner join " +
            " school c on s.schoolId=c.schoolId inner JOIN classes l on s.schoolId=l.schoolId" +
            " where  1=1 " +
            " <if test ='studentPaperId != null and studentPaperId !=\"\"'>" +
            "   and studentPaperId like '%${studentPaperId}%'" +
            " </if>" +
            " <if test ='studentName != null and studentName !=\"\"'>" +
            "   and studentName like '%${studentName}%'" +
            " </if>" +
            " <if test ='schoolId != null and schoolId !=\"\" and schoolId !=\"0\" '>" +
            "   and s.schoolId = '${schoolId}'" +
            " </if>" +
            " <if test ='schoolName != null and schoolName !=\"\" '>" +
            "   and s.schoolName like '%${schoolName}%'" +
            " </if>" +
            " </script>")
    public List<Map<String,Object>> studentListTotal(StudentQueryParams queryParams);

    @Select("select id,studentId,studentPaperId,studentName,sex,birthday,tel,address,schoolId,wxCode,headimg,nickname,regTime,endTime" +
            " from student where studentId ='${studentId}' order by id desc limit 1 ")
    public List<Student> findStudentById(Map<String,Object> paras);

    @Insert("insert into student(studentId,studentPaperId,studentName,tel,address,sex,birthday,schoolId,regTime,inviteCode,wxcode,headimg,nickname,relationShipId) " +
            "values(#{studentId},#{studentPaperId},#{studentName},#{tel},#{address},#{sex},#{birthday},#{schoolId}," +
            " now(),func_makeInviteCode(6,'student'), #{wxcode},#{headimg},#{nickname},#{relationShipId})")
    public int insertStudent(Student student);


    @Update("<script>" +
            " update student set endTime = now() where studentId='${studentId}' and schoolId ='${schoolId}'" +
            "</script>")
    public int studentLeaveSchool(Student student);

    @Insert("<script>" +
            "  insert into student(studentId,studentPaperId,studentName,tel,address,sex,birthday,schoolId,regTime,inviteCode)  values" +
            " <foreach collection =\"list\" item=\"s\" separator =\",\" >" +
            " (#{s.studentId}, #{s.studentPaperId},#{s.studentName},#{s.tel},#{s.address},#{s.sex},#{s.birthday},#{s.schoolId},now(),func_makeInviteCode(6,'student')) " +
            "</foreach>" +
            "</script>")
    public int groupInsertStudent(List<Student> students);


    @Update("update student set studentPaperId='${studentPaperId}',studentName='${studentName}',tel='${tel}'," +
            " address='${address}', sex=${sex},birthday=#{birthday},schoolId='${schoolId}',wxcode='${wxcode}' ,headimg= '${headimg}'," +
            " nickname='${nickname}', relationshipId='${relationShipId}' " +
            " where studentId= '${studentId}'")
    public int updateStudent(Student student);





    @Delete("delete from student where id =${id}")
    public int deleteStudent(@Param("id") String id);


    // 学生解绑微信
    @Update("<script>" +
            " update student set wxcode=replace( replace(wxcode,'${openId},','') , '${openId}','') where studentId='${studentId}' " +
            "</script>")
    public int studentUnbindWx(@Param("openId") String openId,@Param("studentId") String studentId);

    // 根据学生id 获取邀请码
    @Select("<script>" +
            " select inviteCode from student where studentId='${studentId}' order by id desc" +
            "</script>")
    public List<Map<String,Object>> studentInviteCodeById(@Param("studentId") String studentId);

}
