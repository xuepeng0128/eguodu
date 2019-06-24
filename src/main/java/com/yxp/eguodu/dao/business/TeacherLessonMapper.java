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
            " SELECT l.lessonId,lessonTitle,l.memo,l.guoduCoin,l.makeTeacherId,t.teacherName AS makeTeacherName, makeTime, " +
            "        l.schoolId,s.schoolName,l.publishTime, ha.habitId,ha.habitName,cir.circleId, cir.circleTitle,l.picUrl " +
            " FROM " +
            " teacherlesson l " +
            " INNER JOIN teacher t ON l.makeTeacherId = t.teacherId " +
            " INNER JOIN school s ON l.schoolId = s.schoolId " +
            " left outer join teacherlessonhabit th on l.lessonId =th.lessonId " +
            " left outer join habit ha on th.habitId=ha.habitId " +
            " left outer join circle cir on ha.circleId=cir.circleId " +
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
            " SELECT count(*) as total  " +
            " FROM " +
            " teacherlesson l " +
            " INNER JOIN teacher t ON l.makeTeacherId = t.teacherId " +
            " INNER JOIN school s ON l.schoolId = s.schoolId " +
            " left outer join teacherlessonhabit th on l.lessonId =th.lessonId " +
            " left outer join habit ha on th.habitId=ha.habitId " +
            " left outer join circle cir on ha.circleId=cir.circleId " +
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
            " select lessonId,lessonNo,lessonNoTitle,mode,memo,picUrl,videoUrl,audioUrl,noPay from subteacherlesson where lessonId ='${lessonId}' " +
            " limit ${pageBegin} , ${pageSize} " +
            "</script>")
    public List<SubTeacherLesson> subTeacherLessonList(@Param("lessonId") String lessonId,@Param("pageBegin") String pageBegin , @Param("pageSize") String pageSize);



    @Insert("insert into  teacherlesson(lessonId,lessonTitle,memo,guoduCoin,makeTeacherId,makeTime,schoolId, picUrl) values" +
            " (#{lessonId},#{lessonTitle},#{memo},#{guoduCoin},#{makeTeacherId},now(),#{schoolId} ,#{picUrl})")
   public int insertTeacherLesson(TeacherLesson teacherLesson);

    @Insert("insert into subteacherlesson(lessonId,lessonNo,lessonNoTitle,memo,picUrl,videoUrl,audioUrl,noPay,mode) values(" +
            " #{lessonId},#{lessonNo},#{lessonNoTitle},#{memo},#{picUrl},#{videoUrl},#{audioUrl},#{noPay} ,#{mode})")
    public int insertSubTeacherLesson(SubTeacherLesson subTeacherLesson);
    @Update("update teacherlesson set lessonTitle=#{lessonTitle},memo=#{memo},guoduCoin=#{guoduCoin},picUrl=#{picUrl} where lessonId=#{lessonId}")
    public int updateTeacherLesson(TeacherLesson teacherLesson);

    @Update("update subteacherlesson set lessonNoTitle=#{lessonNoTitle},memo= #{memo},picUrl=#{picUrl},videoUrl=#{videoUrl},audioUrl=#{audioUrl},noPay=#{noPay}")
    public int updateSubTeacherLesson(SubTeacherLesson subTeacherLesson);

    @Delete("delete from teacherlesson where lessonId=#{lessonId}")
    public int deleteTeacherLesson(Map<String,Object> paras);

    @Delete("delete from  subteacherlesson where lessonId=#{lessonId}")
    public int deleteSubTeacherLesson(@Param("lessonId") String lessonId);


    @Insert("<script>" +
            "  insert into teacherlessonhabit(lessonId,habitId) values(#{lessonId},#{habitId})" +
            "</script>")
    public int publishToHabit(@Param("lessonId") String lessonId, @Param("habitId") String habitId);

    @Update("<script>" +
            " update teacherLesson set publishTime = now() where lessonId=#{lessonId}" +
            "</script>")
    public int setPublishTime(@Param("lessonId") String lessonId);




    //--------------------------微信-----------------------------//

 // 根据circleid 获取课程

 @Select("<script>" +
         " select l.lessonId,lessonTitle,l.memo, l.guoduCoin, makeTeacherId, t.teacherName as makeTeacherName," +
         " l.picUrl,l.publishTime , case when sbl.studentId is null then false else true end as haveBuy from teacherlesson l " +
         "inner join teacher t on l.makeTeacherId=t.teacherId and l.schoolId=t.schoolId " +
         "inner join teacherlessonhabit h on l.lessonId=h.lessonId  INNER JOIN " +
         "habit ha on h.habitId=ha.habitId  left outer join studentbuylesson sbl on l.lessonId=sbl.lessonId and sbl.studentId='${studentId}' " +
         "where ha.circleId='${circleId}' order by l.publishTime desc " +
         " limit ${pageBegin},${pageSize}  " +
         "</script>")
  public List<Map<String,Object>> teacherLessonByCircleId(@Param("circleId") String circleId ,@Param("studentId") String studentId,@Param("pageSize") String pageSize, @Param("pageBegin") String pageBegin);


// 购买课程
 @Insert("<script>" +
         " insert into studentbuylesson(lessonId,studentId,spendGuoduCoin,buyTime) " +
         " values( '${lessonId}','${studentId}',${guoduCoin},now())" +
         "</script>")
 public int studentBuyLesson(@Param("lessonId") String lessonId,@Param("studentId") String studentId, @Param("guoduCoin") String guoduCoin);






}
