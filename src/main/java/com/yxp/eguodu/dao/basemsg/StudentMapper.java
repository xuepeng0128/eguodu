package com.yxp.eguodu.dao.basemsg;

import com.yxp.eguodu.common.queryparams.StudentQueryParams;
import com.yxp.eguodu.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


@Mapper
public interface StudentMapper {
    @Select("<script>" +
            " select id,studentId, paperId,studentName,tel,s.address,s.schoolId,c.schoolName,l.grade,l.classes,l.classesName ,c.schoolStyle,c.train " +
            " from student s inner join " +
            " school c on s.schoolId=c.schoolId inner JOIN classes l on s.schoolId=l.schoolId" +
            " where  1=1 " +
            " <if test ='paperId != null and paperId !=\"\"'>" +
            "   and paperId like '%${paperId}%'" +
            " </if>" +
            " <if test ='studentName != null and studentName !=\"\"'>" +
            "   and studentName like '%${studentName}%'" +
            " </if>" +
            " <if test ='schoolId != null and schoolId !=\"\" and schoolId !=0'>" +
            "   and s.schoolId = '${schoolId}'" +
            " </if>" +
            " <if test ='schoolName != null and schoolName !=\"\" '>" +
            "   and s.schoolName like '%${schoolName}%'" +
            " </if>" +
            " limit ${pageBegin} ,${pageSize}" +
            " </script>")
    public List<Map<String,Object>> studentList(StudentQueryParams queryParams);

    @Select("<script>" +
            " select count(*) as total " +
            " from student s inner join " +
            " school c on s.schoolId=c.schoolId inner JOIN classes l on s.schoolId=l.schoolId" +
            " where  1=1 " +
            " <if test ='paperId != null and paperId !=\"\"'>" +
            "   and paperId like '%${paperId}%'" +
            " </if>" +
            " <if test ='studentName != null and studentName !=\"\"'>" +
            "   and studentName like '%${studentName}%'" +
            " </if>" +
            " <if test ='schoolId != null and schoolId !=\"\" and schoolId !=0'>" +
            "   and s.schoolId = '${schoolId}'" +
            " </if>" +
            " <if test ='schoolName != null and schoolName !=\"\" '>" +
            "   and s.schoolName like '%${schoolName}%'" +
            " </if>" +
            " </script>")
    public List<Map<String,Object>> studentListTotal(StudentQueryParams queryParams);

    @Insert("insert into student(paperId,studentName,tel,address,schoolId,regTime) " +
            "values('${paperId}','${studentName}','${tel}','${address}','${schoolId}',now())")
    public int insertStudent(Student student);


    @Insert("<script>" +
            "  insert into student(paperId,studentName,tel,address,schoolId,regTime)  values" +
            " <foreach collection =\"list\" item=\"s\" separator =\",\" >" +
            " ('${s.paperId}','${s.studentName}','${s.tel}','${s.address}','${s.schoolId}',now()) " +
            "</foreach>" +
            "</script>")
    public int groupInsertStudent(List<Student> students);


    @Update("update student set paperId='${paperId}',studentName='${studentName}',tel='${tel}'," +
            " address='${address}',schoolId='${schoolId}',wxCode='${wxCode}' where id= ${id}")
    public int updateStudent(Student student);

    @Delete("delete from student where id =${id}")
    public int deleteStudent(@Param("id") String id);
}
