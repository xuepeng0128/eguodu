package com.yxp.eguodu.dao.business;

import com.yxp.eguodu.entity.SubTeacherLesson;
import com.yxp.eguodu.entity.TeacherLesson;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherLessonMapper {


    @Select(" <script>" +
            "   select lessonId,lessonTitle,memo,guoduCoin,makeTeacherId, t.teacherName as makeTeacherName," +
            "  makeTime,l.schoolId , s.schoolName,l.publishTime from teacherlesson l inner join teacher t on l.makeTeacherId=t.teacherId " +
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

    @Select("select * from teacherlesson where lessonId='${lessonId}'")
    public List<Map<String,Object>> getTeacherLessonByLessonId( @Param("lessonId")  String lessonId);

    @Select("<script>" +
            "  select lessonId ,habitId from lessonhabit where lessonId ='${lessonId}'" +
            "</script>")
    public List<Map<String,Object>> lessonHabitList(Map<String,Object> paras);

    @Select("<script> " +
            " select lessonId,lessonNo,memo,videoUrl,audioUrl,noPay from subteacherlesson where lessonId ='${lessonId}' " +
            "</script>")
    public List<SubTeacherLesson> subTeacherLessonList(Map<String,Object> paras);



    @Insert("insert into  teacherlesson(lessonId,lessonTitle,memo,guoduCoin,makeTeacherId,makeTime,schoolId) values" +
            " (#{lessonId},#{lessonTitle},#{memo},#{guoduCoin},#{makeTeacherId},#{makeTime},#{schoolId})")
   public int insertTeacherLesson(TeacherLesson teacherLesson);

    @Insert("insert into subteacherlesson(lessonId,lessonNo,memo,videoUrl,audioUrl,noPay) values(" +
            " #{lessonId},#{lessonNo},#{memo},#{videoUrl},#{audioUrl},#{noPay})")
    public int insertSubTeacherLesson(SubTeacherLesson subTeacherLesson);
    @Update("update teacherlesson set lessonTitle=#{lessonTitle},memo=#{memo},guoduCoin=#{guoduCoin} where lessonId=#{lessonId}")
    public int updateTeacherLesson(TeacherLesson teacherLesson);

    @Update("update subteacherlesson set #{memo},#{videoUrl},#{audioUrl},#{noPay}")
    public int updateSubTeacherLesson(SubTeacherLesson subTeacherLesson);
    @Delete("delete teacherlesson where lessonId=#{lessonId}")
    public int deleteTeacherLesson(Map<String,Object> paras);

    @Delete("delete subteacherlesson where lessonId=#{lessonId} and lessonNo=#{lessonNo}")
    public int deleteSubTeacherLesson(@Param("lessonId") String lessonId, @Param("lessonNo") int lessonNo);




}
