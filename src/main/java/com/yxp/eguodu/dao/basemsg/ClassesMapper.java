package com.yxp.eguodu.dao.basemsg;

import com.yxp.eguodu.common.queryparams.ClassesQueryParams;
import com.yxp.eguodu.entity.Classes;
import com.yxp.eguodu.entity.ClassesStudent;
import com.yxp.eguodu.entity.ClassesTeacher;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClassesMapper {

    @Select("<script> " +
            " select c.classesId,c.classes,c.grade,c.classesName,c.headMaster,ifnull(dt.teacherName,'') as headMasterName," +
            "   s.schoolId,s.schoolName, ifnull(t.teacherNum,0) as teacherNum , ifnull(d.studentNum,0) as studentNum " +
            "  from classes c inner join school s on c.schoolId=s.schoolId  " +
            "  left outer join v_onDutyTeacher dt on c.headMaster=dt.teacherId " +
            "left outer join " +
            "( " +
            "  select classesId, ifnull(count(*),0) as teacherNum  from  classesteacher  " +
            "  group by  classesId  " +
            " " +
            ") t on  c.classesId=t.classesId " +
            "left outer join  " +
            "( " +
            "  select classesId, ifnull(count(*),0) as studentNum  from  classesstudent  " +
            "  group by  classesId  " +
            " " +
            ") d on c.classesId=d.classesId " +
            "where 1=1 " +
            " " +
            " <if test='classesId != null and classedId !=\"\" and classesId !=\"0\" '>" +
            "    and c.classesId='${classesId}'" +
            " </if>" +
            " <if test='grade != null and grade !=\"\" and grade !=\"0\" '>" +
            "    and c.grade=${grade}" +
            " </if>" +
            " <if test='classes != null and classes !=\"\" and classes !=\"0\" '>" +
            "    and c.classes=${classes}" +
            " </if>" +
            " <if test='schoolId != null and schoolId !=\"\" and schoolId !=\"0\" '>" +
            "    and c.schoolId='${schoolId}'" +
            " </if>" +
            " <if test='schoolName != null and schoolName !=\"\" and schoolName !=\"0\" '>" +
            "    and s.schoolName='${schoolName}'" +
            " </if>" +
            " limit ${pageBegin},${pageSize}" +
            "</script>")
   public List<Map<String,Object>> classesList(ClassesQueryParams params);



    @Select("<script> " +
            " select count(*) as total " +
            "  from classes c inner join school s on c.schoolId=s.schoolId  " +
            "  left outer join v_onDutyTeacher dt on c.headMaster=dt.teacherId " +
            "left outer join " +
            "( " +
            "  select classesId, ifnull(count(*),0) as teacherNum  from  classesteacher  " +
            "  group by  classesId  " +
            " " +
            ") t on  c.classesId=t.classesId " +
            "left outer join  " +
            "( " +
            "  select classesId, ifnull(count(*),0) as studentNum  from  classesstudent  " +
            "  group by  classesId  " +
            " " +
            ") d on c.classesId=d.classesId " +
            "where 1=1 " +
            " <if test='classesId != null and classedId !=\"\" and classesId !=\"0\" '>" +
            "    and c.classesId='${classesId}'" +
            " </if>" +
            " <if test='grade != null and grade !=\"\" and grade !=\"0\" '>" +
            "    and c.grade=${grade}" +
            " </if>" +
            " <if test='classes != null and classes !=\"\" and classes !=\"0\" '>" +
            "    and c.classes=${classes}" +
            " </if>" +
            " <if test='schoolId != null and schoolId !=\"\" and schoolId !=\"0\" '>" +
            "    and c.schoolId='${schoolId}'" +
            " </if>" +
            " <if test='schoolName != null and schoolName !=\"\" and schoolName !=\"0\" '>" +
            "    and s.schoolName='${schoolName}'" +
            " </if>" +
            "</script>")
    public List<Map<String,Object>> classesListTotal(ClassesQueryParams params);




    @Insert(" insert into classes(classesId,grade,classes,classesName,schoolId,headMaster,regTime) values(" +
            " func_makeBusinessId('classes',#{schoolId}),#{grade},#{classes},#{classesName},#{schoolId},#{headMaster},now() )")
    public int insertClasses(Classes classes);

    @Update(" update classes set grade=#{grade} , classes=#{classes} ,classesName=#{classesName}," +
            " schoolId =#{schoolId},headMaster=#{headMaster} where classesId=#{classesId} ")
    public  int updateClasses(Classes classes);

    @Delete(" delete from classes where classesId=#{classesId}")
    public int deleteClasses(Map<String,Object> paras);


    @Select("<script> " +
            "select sub.studySubjectId, sub.studySubjectName ,st.teacherId , t.teacherName from " +
            "( " +
            "select studySubjectId,studySubjectName from dic_studysubject " +
            " where 1=1 " +
            " <if test='schoolStyle==1'>" +
            "  and primarySchool=1 " +
            " </if>" +
            " <if test='schoolStyle==2'>" +
            "  and middleSchool=2 " +
            " </if>" +
            ") sub left outer join " +
            "(  " +
            " select studySubjectId , teacherId from classesteacher where classesId='${classesId}' and endTime is null " +
            ") st on sub.studySubjectId=st.studySubjectId left outer join teacher t on st.teacherId=t.teacherName " +
            "</script>")
    public List<Map<String,Object>> classesTeacherList(Map<String,Object> paras);


    @Insert("<script>" +
            "  insert into classesteacher(classesId,teacherId,studySubjectId,regTime)  values" +
            " (#{classesId},#{teacherId},#{studySubjectId},now()) " +
            "</script>")
    public int insertClassesTeacher(ClassesTeacher classesTeacher);

    @Update("<script>" +
            " update classesteacher set endTime=now() where classesId='${classesId}' and teacherId='${teacherId}' " +
            " and studySubjectId='${studySubjectId}'" +
            "</script>")
    public int classesTeacherLeave(Map<String,Object> paras);
    @Insert("<script>" +
            "  insert into classesstudent(classesId,studentId,regTime)  values" +
            " <foreach collection =\"list\" item=\"s\" separator =\",\" >" +
            "    ('${s.classesId}','${s.studentId}',now()) " +
            " </foreach>" +
            "</script>")
    public int groupInsertClassesStudents(List<ClassesStudent> classesStudents);

   @Insert("<script>" +
         "  insert into classesstudent(classesId,studentId,regTime)  values" +
         "    ('${classesId}','${studentId}',now()) " +
         "</script>")
    public int insertSingleClassesStudent(ClassesStudent classesStudent);

   @Update("<script> update classesstudent set endTime=now() " +
           "where classesId='${classedId}' and studentId='${studentId}' " +
           "</script>")
    public int classesStudentLeave(Map<String,Object> paras);






}
