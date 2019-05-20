package com.yxp.eguodu.dao.business;

import com.yxp.eguodu.common.queryparams.HabitQueryParams;
import com.yxp.eguodu.entity.Habit;
import com.yxp.eguodu.entity.HabitExam;
import com.yxp.eguodu.entity.HabitStudent;
import com.yxp.eguodu.entity.StudentPutCard;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface HabitMapper {

@Select("<script>" +
        "   select h.habitId, h.circleId,c.circleTitle,h.habitClassId ,p.habitClassName,h.subHabitClassId,s.habitClassName " +
        "       as subHabitClassName ,h.icon,h.color,h.habitName,h.memo,h.picUrl,h.pirTime,h.timeUnit,h.`mode`,h.timeModeNum, " +
        "      h.countModeNum,h.valueModeNum,h.unitName,guoduCoin,h.score,h.putCardExamId,h.buildTeacherId,h.buildStudentId,h.buildTime " +
        "  from habit h inner join circle c on h.circleId=c.circleId " +
        "inner join dic_habitclass p on h.habitClassId=p.habitClassId  inner join dic_habitclass s on h.subHabitClassId " +
        " =s.habitClassId " +
        "where 1=1 " +
        " <if test ='habitId != null and habitId != \"\" and habitId != \"0\"'>" +
        "     and h.habitId='${habitId}'" +
        " </if> " +
        " <if test ='circleId != null and circleId != \"\" and circleId != \"0\"'>" +
        "     and h.circleId='${circleId}'" +
        " </if> " +
        " <if test ='habitClassId != null and habitClassId != \"\" and habitClassId != \"0\"'>" +
        "     and h.habitClassId='${habitClassId}'" +
        " </if> " +
        " <if test ='subHabitClassId != null and subHabitClassId != \"\" and subHabitClassId != \"0\"'>" +
        "     and h.subHabitClassId='${subHabitClassId}'" +
        " </if> " +
        " <if test ='schoolId != null and schoolId != \"\" and schoolId != \"0\"'>" +
        "     and c.schoolId='${schoolId}'" +
        " </if> " +
        " <if test ='teacherId != null and teacherId != \"\" and teacherId != \"0\"'>" +
        "     and c.buildTeacherId='${teacherId}'" +
        " </if> " +
        " <if test ='circleTitle != null and circleTitle != \"\" '>" +
        "     and c.circleTitle like '%${circleTitle}%'" +
        " </if> " +
        " <if test ='habitName != null and habitName != \"\" '>" +
        "     and h.habitName like '%${habitName}%'" +
        " </if> " +
        "  limit ${pageBegin},${pageSize}" +
        "</script>")
    public List<Habit> habitList(HabitQueryParams habitQueryParams);


    @Select("<script>" +
            "   select count(*) as total  " +
            "  from habit h inner join circle c on h.circleId=c.circleId " +
            "inner join dic_habitclass p on h.habitClassId=p.habitClassId  inner join dic_habitclass s on h.subHabitClassId " +
            " =s.habitClassId " +
            "where 1=1 " +
            " <if test ='habitId != null and habitId != \"\" and habitId != \"0\"'>" +
            "     and h.habitId='${habitId}'" +
            " </if> " +
            " <if test ='circleId != null and circleId != \"\" and circleId != \"0\"'>" +
            "     and h.circleId='${circleId}'" +
            " </if> " +
            " <if test ='habitClassId != null and habitClassId != \"\" and habitClassId != \"0\"'>" +
            "     and h.habitClassId='${habitClassId}'" +
            " </if> " +
            " <if test ='subHabitClassId != null and subHabitClassId != \"\" and subHabitClassId != \"0\"'>" +
            "     and h.subHabitClassId='${subHabitClassId}'" +
            " </if> " +
            " <if test ='schoolId != null and schoolId != \"\" and schoolId != \"0\"'>" +
            "     and c.schoolId='${schoolId}'" +
            " </if> " +
            " <if test ='buildTeacherId != null and buildTeacherId != \"\" and buildTeacherId != \"0\"'>" +
            "     and h.buildTeacherId='${buildTeacherId}'" +
            " </if> " +
            " <if test ='buildStudentId != null and buildStudentId != \"\" and buildStudentId != \"0\"'>" +
            "     and h.buildStudentId='${buildStudentId}'" +
            " </if> " +
            " <if test ='circleTitle != null and circleTitle != \"\" '>" +
            "     and c.circleTitle like '%${circleTitle}%'" +
            " </if> " +
            " <if test ='habitName != null and habitName != \"\" '>" +
            "     and h.habitName like '%${habitName}%'" +
            " </if> " +
            "</script>")
    public List<Map<String,Object>> habitListTotal(HabitQueryParams habitQueryParams);

    @Insert("<script>" +
            "  insert into habit (habitId,circleId,habitClassId,subHabitClassId,icon,color,habitName,memo,picUrl,pirTime," +
            " timeUnit,mode,timeModeNum,countModeNum,valueModeNum,unitName,guoduCoin,score,putCardExamId,buildTime," +
            " buildTeacherId,buildStudentId,putcardBeginDate,putcardEndDate) values(" +
            " #{habitId},#{circleId},#{habitClassId},#{subHabitClassId},#{icon},#{color},#{habitName},#{memo},#{picUrl},#{pirTime}," +
            "  #{timeUnit},#{mode},#{timeModeNum},#{countModeNum},#{valueModeNum},#{unitName},#{guoduCoin},#{score},#{putCardExamId},now()," +
            "  #{buildTeacherId},#{buildStudentId},#{putcardBeginDate},#{putcardEndDate})" +
            " </script> ")
    public int insertHabit(Habit habit);

    @Insert("<script> " +
            "  insert into habitexam(habitExamId,teacherId,publishedDate,examTitle,examMemo,examBeginDate,examEndDate,totalScore) values(" +
            " #{habitExamId,#{teacherId},now(),#{examTitle},#{examMemo},#{examBeginDate},#{examEndDate},#{totalScore})" +
            " </script> ")
    public int insertHabitExam(HabitExam habitExam);

    @Insert("<script> insert into habitstudent(habitId,studentId,joinTime) values(" +
            " #{habitId},#{studentId},now())" +
            " </script>")
    public int insertHabitStudent(HabitStudent habitStudent);


    @Insert("<script> " +
            " insert into studentputcard(habitId,studentId,shouldPutCardDateBegin,shouldPutCardDateEnd,canGetGuodubi," +
            "upperLimitGuodubi,canGetScore,putCardTime,putCardMemo,putCardPicUrls,putCardaudioUrls,putCardvideoUrls,shouldFinish)  values" +
            " <foreach collection =\"list\" item=\"t\" separator =\",\" >" +
            " ( #{t.habitId},#{t.studentId},#{t.shouldPutCardDateBegin},#{t.shouldPutCardDateEnd},#{t.canGetGuodubi}," +
            "       #{t.upperLimitGuodubi},#{t.canGetScore},#{t.putCardTime},#{t.putCardMemo},#{t.putCardPicUrls},#{t.putCardaudioUrls},#{t.putCardvideoUrls},#{t.shouldFinish} )" +
            "</foreach>" +

            " </script>")
    public int groupInsertStudentPutCardPlan(List<StudentPutCard> studentPutCard);

   @Update("")
    public int studentPutCard(@Param("habitId") String habitId , @Param("studentId") String studentId);

}
