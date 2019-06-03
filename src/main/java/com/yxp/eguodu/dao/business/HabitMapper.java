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
        "   select h.habitId,cla.grade, cla.classes ,  h.circleId,c.circleTitle,h.habitClassId ,p.habitClassName,h.subHabitClassId,s.habitClassName " +
        "       as subHabitClassName ,h.icon,h.color,h.habitName,h.memo,h.picUrl,h.pirTime,h.timeUnit,h.`mode`,h.timeModeNum, h.timeCompare," +
        "      h.countModeNum,h.valueModeNum,h.unitName,guoduCoin,h.score,h.habitExamId,e.examTitle , e.totalScore ," +
        "    h.buildTeacherId,h.buildStudentId,h.buildTime,ifnull(stu.joinStudents,0) as joinStudents " +
        "  from habit h inner join circle c on h.circleId=c.circleId  " +
        "inner join dic_habitclass p on h.habitClassId=p.habitClassId  inner join dic_habitclass s on h.subHabitClassId " +
        " =s.habitClassId left outer join habitexam e on h.habitExamId=e.habitExamId  left outer join classes cla on c.classesId=cla.classesId" +
        " left outer join (select habitId , count(studentId) as joinStudents from habitstudent group by habitId  )stu on h.habitId=stu.habitId " +
        "where 1=1 " +
        " <if test ='habitId != null and habitId != \"\" and habitId != \"0\"'>" +
        "     and h.habitId='${habitId}'" +
        " </if> " +
        " <if test ='circleId != null and circleId != \"\" and circleId != \"0\"'>" +
        "     and h.circleId='${circleId}'" +
        " </if> " +
        " <if test ='classesId != null and classesId != \"\" and classesId != \"0\"'>" +
        "     and c.classesId in (${classesId})" +
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
        "     and c.buildTeacherId='${buildTeacherId}'" +
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
        " <if test ='examed == \"1\" '>" +
        "  <![CDATA[   and ifnull(h.habitExamId,'')  <> '' ]]> " +
        " </if> " +
        " <if test ='examed == \"0\" '>" +
        "      and ifnull(h.habitExamId,'') ='' " +
        " </if> " +
        " order by h.habitExamId ,h.habitId" +
        "  limit ${pageBegin},${pageSize}" +
        "</script>")
    public List<Habit> habitList(HabitQueryParams habitQueryParams);


    @Select("<script>" +
            "   select count(*) as total  " +
            "  from habit h inner join circle c on h.circleId=c.circleId  " +
            "inner join dic_habitclass p on h.habitClassId=p.habitClassId  inner join dic_habitclass s on h.subHabitClassId " +
            " =s.habitClassId left outer join habitexam e on h.habitExamId=e.habitExamId  left outer join classes cla on c.classesId=cla.classesId" +
            " left outer join (select habitId , count(studentId) as joinStudents from habitstudent group by habitId  )stu on h.habitId=stu.habitId " +
            "where 1=1 " +
            " <if test ='habitId != null and habitId != \"\" and habitId != \"0\"'>" +
            "     and h.habitId='${habitId}'" +
            " </if> " +
            " <if test ='circleId != null and circleId != \"\" and circleId != \"0\"'>" +
            "     and h.circleId='${circleId}'" +
            " </if> " +
            " <if test ='classesId != null and classesId != \"\" and classesId != \"0\"'>" +
            "     and c.classesId in (${classesId})" +
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
            "     and c.buildTeacherId='${buildTeacherId}'" +
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
            " <if test ='examed == \"1\" '>" +
            "  <![CDATA[   and ifnull(h.habitExamId,'')  <> '' ]]> " +
            " </if> " +
            " <if test ='examed == \"0\" '>" +
            "      and ifnull(h.habitExamId,'') ='' " +
            " </if> " +
            "</script>")
    public List<Map<String,Object>> habitListTotal(HabitQueryParams habitQueryParams);

    @Insert("<script>" +
            "  insert into habit (habitId,circleId,habitClassId,subHabitClassId,icon,color,habitName,memo,picUrl,pirTime," +
            " timeUnit,mode,timeModeNum,timeCompare,countModeNum,valueModeNum,unitName,guoduCoin,score,habitExamId,buildTime," +
            " buildTeacherId,buildStudentId,putcardBeginDate,putcardEndDate) values(" +
            " #{habitId},#{circleId},#{habitClassId},#{subHabitClassId},#{icon},#{color},#{habitName},#{memo},#{picUrl},#{pirTime}," +
            "  #{timeUnit},#{mode},#{timeModeNum},#{timeCompare},#{countModeNum},#{valueModeNum},#{unitName},#{guoduCoin},#{score},#{habitExamId},now()," +
            "  #{buildTeacherId},#{buildStudentId},#{putCardBeginDate},#{putCardEndDate})" +
            " </script> ")
    public int insertHabit(Habit habit);

    @Insert("<script> " +
            "  insert into habitexam(habitExamId,teacherId,publishedDate,examTitle,examMemo,examBeginDate,examEndDate,totalScore) values(" +
            " #{habitExamId},#{teacherId},now(),#{examTitle},#{examMemo},#{examBeginDate},#{examEndDate},#{totalScore})" +
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

    @Select("<script>" +
            " select pt.studentId,  count(*) as puts from " +
            "  ( " +
            "     select habitId from habit where habitExamId='${habitExamId}' " +
            "  ) ex inner join studentputcard pt on ex.habitId=pt.habitId " +
            " group by pt.studentId " +
            " limit 1" +
            "</script>")
    public List<Map<String,Object>> examPutCards(@Param("habitExamId") String habitExamId);

    @Update("<script>" +
            "  update studentputcard  set canGetScore=#{canGetScore} where habitId in (select habitId from habit where habitExamId=#{habitExamId} )" +
            "</script>")
    public int setCanGetScore(@Param("habitExamId") String habitExamId,@Param("canGetScore") float canGetScore);


    // 打卡 ，1.设置是否完成打卡任务

   @Update("<script>" +
           "  update studentputcard set haveFinish = '${haveFinish}' ,  " +
           "                          finished= case when finishCompare ='gt'  then " +
           "                                           case when haveFinish>= shouldFinish then true else FALSE end  " +
           "                                    ELSE " +
           "                                           case when haveFinish<= shouldFinish then true else FALSE end   " +
           "                                    end " +
           "  where id=#{id}  " +
           "</script>")
    public int studentPutCardSetFinish(StudentPutCard studentPutCard);

   // 打卡 2.修改其他值

    @Update("<script>" +
            " update studentputcard set " +
            "                          haveGuodubi = case when finished =1 THEN " +
            "                                             case when func_calCanGetGuodubi('${studentId}')+ haveGuodubi  > canGetGuodubi  " +
            "                                             then canGetGuodubi  " +
            "                                             else func_calCanGetGuodubi('${studentId}')+ haveGuodubi end  " +
            "                                        else 0 end " +
            "                            , " +
            "                         upperLimitGuodubi =  0  , " +
            "                         haveScore  = case when finished =1 THEN " +
            "                                               canGetScore " +
            "                                        else 0 end    , " +
            "                         putCardTime =now() , " +
            "                         putCardMemo ='${putCardMemo}', " +
            "                      putCardPicUrls ='${putCardPicUrls}', " +
            "                    putCardaudioUrls ='${putCardaudioUrls}', " +
            "                    putCardvideoUrls ='${putCardvideoUrls}'   " +
            "  where id=${id}  " +
            "</script>")
    public int studentPutCart(StudentPutCard studentPutCard);

}
