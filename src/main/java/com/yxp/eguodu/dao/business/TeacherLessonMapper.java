package com.yxp.eguodu.dao.business;

import com.yxp.eguodu.entity.SubTeacherLesson;
import com.yxp.eguodu.entity.TeacherLesson;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherLessonMapper {


    @Select(" <script>" +
            "   select lessonId,lessonTitle,memo,guoduCoin,makeTeacherId, t.teacherName as makeTeacherName," +
            "  makeTime,l.schoolId , s.schoolName from teacherlesson l inner join teacher t on l.makeTeacherId=t.teacherId " +
            "  inner join school s on l.schoolId=s.schoolId " +
            " where 1=1 " +
            " <if test='schoolId != null and schoolId !=\"\" and schoolId !=\"0\"'>" +
            "   and l.schoolId ='${schoolId}'" +
            "</if>" +
            " <if test='teacherId != null and teacherId !=\"\" and teacherId !=\"0\"'>" +
            "   and l.makeTeacherId ='${teacherId}'" +
            "</if>" +
            " limit $pageBegin,$pageSize " +
            "</script>")
   public List<TeacherLesson> teacherLessonList(Map<String,Object> paras);



    @Select(" <script>" +
            "   select count(*) as total from teacherlesson l inner join teacher t on l.makeTeacherId=t.teacherId " +
            "  inner join school s on l.schoolId=s.schoolId " +
            " where 1=1 " +
            " <if test='schoolId != null and schoolId !=\"\" and schoolId !=\"0\"'>" +
            "   and l.schoolId ='${schoolId}'" +
            "</if>" +
            " <if test='teacherId != null and teacherId !=\"\" and teacherId !=\"0\"'>" +
            "   and l.makeTeacherId ='${teacherId}'" +
            "</if>" +
            "</script>")
    public List<Map<String,Object>> teacherLessonListTotal(Map<String,Object> paras);

    @Select("<script>" +
            "  select lessonId ,habitId from lessonhabit where lessonId ='${lessonId}'" +
            "</script>")
    public List<Map<String,Object>> lessonHabitList(Map<String,Object> paras);

    @Select("<script> " +
            " select lessonId,lessonNo,memo,videoUrl,audioUrl,noPay from subteacherlesson where lessonId ='${lessonId}' " +
            "</script>")
    public List<SubTeacherLesson> subTeacherLessonList(Map<String,Object> paras);



    @Insert("insert into  teacherlesson(lessonId,lessonTitle\n" +
            "memo\n" +
            "guoduCoin\n" +
            "makeTeacherId\n" +
            "makeTime\n" +
            "schoolId\n) ")


}
