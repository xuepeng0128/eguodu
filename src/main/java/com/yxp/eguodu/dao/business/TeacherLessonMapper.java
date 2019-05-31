package com.yxp.eguodu.dao.business;

import com.yxp.eguodu.common.queryparams.TeacherLessonQueryParams;
import com.yxp.eguodu.entity.SubTeacherLesson;
import com.yxp.eguodu.entity.TeacherLesson;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherLessonMapper {


    @Select(" <script>" +
            "   select l.lessonId,lessonTitle,memo,guoduCoin,makeTeacherId, t.teacherName as makeTeacherName," +
            "  makeTime,l.schoolId , s.schoolName,l.publishTime, ifnull(th.habitNum,0) as habitNum from teacherlesson l inner join teacher t on l.makeTeacherId=t.teacherId " +
            "  inner join school s on l.schoolId=s.schoolId left outer join " +
            "  (select lessonId, count(*) as habitNum from teacherlessonhabit ) th on l.lessonId=th.lessonId " +
            " where 1=1 " +
            " <if test='lessonTitle != null and lessonTitle !=\"\" '>" +
            "   and lessonTitle  like '%${lessonTitle}%'" +
            "</if>" +
            " <if test='schoolId != null and schoolId !=\"\" and schoolId !=\"0\"'>" +
            "   and l.schoolId ='${schoolId}'" +
            "</if>" +
            " <if test='teacherId != null and teacherId !=\"\" and teacherId !=\"0\"'>" +
            "   and l.makeTeacherId ='${teacherId}'" +
            "</if>" +
            " limit ${pageBegin},${pageSize} " +
            "</script>")
   public List<TeacherLesson> teacherLessonList(TeacherLessonQueryParams queryParams);



    @Select(" <script>" +
            "   select count(*) as total from teacherlesson l inner join teacher t on l.makeTeacherId=t.teacherId " +
            "  inner join school s on l.schoolId=s.schoolId " +
            " where 1=1 " +
            " <if test='lessonTitle != null and lessonTitle !=\"\" '>" +
            "   and lessonTitle  like '%${lessonTitle}%'" +
            "</if>" +
            " <if test='schoolId != null and schoolId !=\"\" and schoolId !=\"0\"'>" +
            "   and l.schoolId ='${schoolId}'" +
            "</if>" +
            " <if test='teacherId != null and teacherId !=\"\" and teacherId !=\"0\"'>" +
            "   and l.makeTeacherId ='${teacherId}'" +
            "</if>" +
            "</script>")
    public List<Map<String,Object>> teacherLessonListTotal(TeacherLessonQueryParams queryParams);

    @Select("select * from teacherlesson where lessonId='${lessonId}'")
    public List<Map<String,Object>> getTeacherLessonByLessonId( @Param("lessonId")  String lessonId);

    @Select("<script>" +
            "  select lessonId ,habitId from lessonhabit where lessonId ='${lessonId}'" +
            "</script>")
    public List<Map<String,Object>> lessonHabitList(Map<String,Object> paras);

    @Select("<script> " +
            " select lessonId,lessonNo,memo,videoUrl,audioUrl,noPay from subteacherlesson where lessonId ='${lessonId}' " +
            "</script>")
    public List<SubTeacherLesson> subTeacherLessonList(@Param("lessonId") String lessonId);



    @Insert("insert into  teacherlesson(lessonId,lessonTitle,memo,guoduCoin,makeTeacherId,makeTime,schoolId) values" +
            " (#{lessonId},#{lessonTitle},#{memo},#{guoduCoin},#{makeTeacherId},now(),#{schoolId})")
   public int insertTeacherLesson(TeacherLesson teacherLesson);

    @Insert("insert into subteacherlesson(lessonId,lessonNo,memo,videoUrl,audioUrl,noPay) values(" +
            " #{lessonId},#{lessonNo},#{memo},#{videoUrl},#{audioUrl},#{noPay})")
    public int insertSubTeacherLesson(SubTeacherLesson subTeacherLesson);
    @Update("update teacherlesson set lessonTitle=#{lessonTitle},memo=#{memo},guoduCoin=#{guoduCoin} where lessonId=#{lessonId}")
    public int updateTeacherLesson(TeacherLesson teacherLesson);

    @Update("update subteacherlesson set #{memo},#{videoUrl},#{audioUrl},#{noPay}")
    public int updateSubTeacherLesson(SubTeacherLesson subTeacherLesson);
    @Delete("delete from teacherlesson where lessonId=#{lessonId}")
    public int deleteTeacherLesson(Map<String,Object> paras);

    @Delete("delete from  subteacherlesson where lessonId=#{lessonId} and lessonNo=#{lessonNo}")
    public int deleteSubTeacherLesson(@Param("lessonId") String lessonId, @Param("lessonNo") int lessonNo);


    @Insert("<script>" +
            "  insert into teacherlessonhabit(lessonId,habitId) values(#{lessonId},#{habitId})" +
            "</script>")
    public int publishToHabit(@Param("lessonId") String lessonId, @Param("habitId") String habitId);

}
