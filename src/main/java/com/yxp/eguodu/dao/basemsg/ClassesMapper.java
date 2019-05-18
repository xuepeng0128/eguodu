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
    public int insertClassesStudent(ClassesStudent classesStudent);

   @Update("<script> update classesstudent set endTime=now() " +
           "where classesId='${classedId}' and studentId='${studentId}' " +
           "</script>")
    public int classesStudentLeave(Map<String,Object> paras);

    @Delete("<script>" +
            "   delete from classesstudent where classesId='${classesId}' and studentId ='${studentId}'" +
            "</script>")
    public int deleteClassesStudent(Map<String,Object> paras);
    @Select("<script>" +
            " select cls.classesId,cls.grade,cls.classes,cls.classesName,cls.schoolId,sch.schoolName,cls.headMaster,ifnull(t.teacherName,'') as teacherName " +
            "  from classes cls inner join " +
            "school sch on cls.schoolId=sch.schoolId " +
            "left outer join teacher t on cls.headMaster=t.teacherId and t.endTime is not null " +
            " where cls.schoolId='${schoolId}' and cls.grade='${grade}'" +
            "</script>")
    public List<Classes> gradeClasses(Map<String,Object> paras);
   @Select("<script>" +
           "   select c.classesId,c.grade,c.classes,c.headMaster ,t.teacherName as headMasterName,c.schoolId from " +
           "( " +
           " select classesId from classesteacher where teacherId='${teacherId}' and endTime is not null " +
           " union " +
           " select classesId from classes where headMaster ='${teacherId}' " +
           ") ac inner join classes c on ac.classesId=c.classesId " +
           " inner join teacher t on c.headMaster=t.teacherId and t.schoolId='${schoolId}' " +
           "</script>")
   public List<Classes> teacherTeachedClasses(Map<String, Object> paras);




   @Select("<script>" +
           " select ct.classesId,ct.teacherId, ct.teacherName , sub.studySubjectId, sub.studySubjectName from dic_studysubject sub  left outer join " +
           "  ( " +
           "          select a.classesId,a.teacherId, t.teacherName,a.studySubjectId from classesteacher a  " +
           "             inner join teacher t on  " +
           "             a.teacherId=t.teacherId and t.schoolId='${schoolId}' " +
           "          where a.classesId='${classesId}' and  a.endTime is null  " +
           "   )ct  on ct.studySubjectId=sub.studySubjectId where 1=1  " +
           " <if test ='schoolStyle==\"1\"'>" +
           "     and  sub.primarySchool=1 " +
           " </if>" +
           " <if test ='schoolStyle==\"2\"'>" +
           "    and  sub.middleSchool=1 " +
           " </if>" +
           " </script>")
  public List<ClassesTeacher> subjectTeachersAtClasses(Map<String,Object> paras);




    @Select("<script>" +
           "  select stu.studentId, stu.studentName, stu.studentPaperId,stu.nickName,stu.tel,stu.address,stu.birthday,stu.sex,stu.schoolId,stu.headimg,stu.nickname,stu.wxcode    from   " +
           "( " +
           "  select classesId,studentId from classesstudent where classesId='${classesId}' and endTime is NULL " +
           ") cstu inner join student stu on cstu.studentId=stu.studentId and stu.schoolId='${schoolId}'  " +
           "</script>")
   public List<Map<String,Object>> studentAtClasses(Map<String,Object> paras);


}
