package com.yxp.eguodu.dao.business;

import com.yxp.eguodu.common.queryparams.HabitQueryParams;
import com.yxp.eguodu.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface HabitMapper {

@Select("<script>" +
        "   select h.habitId,cla.grade, cla.classes ,  h.circleId,c.circleTitle,h.habitClassId ,p.habitClassName,h.subHabitClassId,s.habitClassName " +
        "       as subHabitClassName ,h.icon,h.color,h.habitName,h.memo,h.picUrl,h.pirTime,h.timeUnit,h.`mode`,h.timeModeNum, h.timeCompare," +
        "      h.countModeNum,h.valueModeNum,h.unitName,guoduCoin,h.score,h.habitExamId,e.examTitle , e.totalScore ," +
        "    h.buildTeacherId,h.buildStudentId,h.buildTime,h.putCardBeginDate,h.putCardEndDate,ifnull(stu.joinStudents,0) as joinStudents " +
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
        " <if test ='allHabitStudentId != null and allHabitStudentId != \"\" '>" +
        "   and h.habitId in  (select distinct habitid from habitstudent  where studentId ='${allHabitStudentId}')" +
        " </if> " +
        " <if test ='todayStudentId != null and todayStudentId != \"\" '>" +
        "   and h.habitId in  (select habitid from studentputcard  where now() BETWEEN shouldPutCardDateBegin and shouldPutCardDateEnd and studentId ='${todayStudentId}')" +
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
            " <if test ='allHabitStudentId != null and allHabitStudentId != \"\" '>" +
            "   and h.habitId in  (select distinct habitid from habitstudent  where studentId ='${allHabitStudentId}')" +
            " </if> " +
            " <if test ='todayStudentId != null and todayStudentId != \"\" '>" +
            "   and h.habitId in  (select habitid from studentputcard  where now() BETWEEN shouldPutCardDateBegin and shouldPutCardDateEnd and studentId ='${todayStudentId}')" +
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





    //------------------------------------------------微信-----------------------------------------//

   // 学生准备打卡，获取打卡信息
   @Select("<script>" +
           " select id,habitId,studentId,shouldPutCardDateBegin,shouldPutCardDateEnd,canGetGuodubi,haveGuodubi,upperLimitGuodubi,canGetScore," +
           " haveScore,putCardTime,putCardMemo,putCardPicUrls,putCardaudioUrls,putCardvideoUrls,shouldFinish,haveFinish,finished," +
           " finishCompare,remark  from studentputcard where now() between shouldPutCardDateBegin and shouldPutCardDateEnd " +
           " and studentId='${studentId}' and habitId='${habitId}' " +
           "</script>")
   public List<StudentPutCard>  currentStudentPrepareHabitPutCard(@Param("habitId") String habitId, @Param("studentId") String studentId);











    // 打卡 ，1.设置是否完成打卡任务

   @Update("<script>" +
           "  update studentputcard set haveFinish = '${haveFinish}' ,  " +
           "                          finished= case when finishCompare ='gt'  then " +
           "                                       <![CDATA[    case when haveFinish>= shouldFinish then true else FALSE end ]]> " +
           "                                    ELSE " +
           "                                       <![CDATA[      case when haveFinish<= shouldFinish then true else FALSE end  ]]> " +
           "                                    end " +
           "  where id=#{id}  " +
           "</script>")
    public int studentPutCardSetFinish(WxPutCard wxPutCard);

   // 打卡 2.修改其他值

    @Update("<script>" +
            " update studentputcard set " +
            "                          haveGuodubi = case when finished =1 THEN " +
            "                                      <![CDATA[         case when func_calCanGetGuodubi('${studentId}')+ haveGuodubi  > canGetGuodubi  ]]>" +
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
            "                    putCardvideoUrls ='${putCardvideoUrls}',  " +
            "                    longitude=${longitude},latitude=${latitude} " +
            "  where id=${id}  " +
            "</script>")
    public int studentPutCart(WxPutCard wxPutCard);





    // 圈子日记

    @Select("<script>" +
            "     select pc.id, stu.nickname, stu.headimg,stu.sex, putCardaudioUrls,putCardMemo,putCardPicUrls,putCardvideoUrls,putCardTime ,\n" +
            "         case when mm.maxPutCardTime is null then 0 else \n" +
            "             TimeStampDiff(DAY,mm.minPutCardTime,mm.maxPutCardTime) +1\n" +
            "         end  as holdDays ,\n" +
            "         ifnull(l.lessonTitle,'') as lessonTitle ,\n" +
            "         ifnull(pag.agrees,'') as agrees \n" +
            "         from (\n" +
            "                 select pi.* from  \n" +
            "                   (SELECT * from  studentputcard  where putCardTime is not null)  pi inner join \n" +
            "                   (\n" +
            "                      SELECT habitid,studentId, max(putCardTime) as maxPutCardTime from studentputcard GROUP BY habitId ,studentId \n" +
            "                  <![CDATA[     having  DATEDIFF(now(),max(putCardTime))>=0 ]]> " +
            "                    )px on pi.habitid =px.habitid and pi.studentid =px.studentId and pi.putcardTime=px.maxPutCardTime\n" +
            "              ) pc\n" +
            "\n" +
            " \n" +
            "           inner join student stu on pc.studentId =stu.studentId and stu.endTime is null \n" +
            "           inner join habit h on pc.habitId=h.habitId \n" +
            "         left outer join  (\n" +
            "                 select studentId , habitId, max(putCardTime) as maxPutCardTime ,\n" +
            "                                             min(putCardTime) as minPutCardTime \n" +
            "                  from studentputcard group by studentId,habitId\n" +
            "                  )mm on pc.habitId=mm.habitId and pc.studentId=mm.studentId \n" +
            "         left outer join (  \n" +
            "               select tlh.habitid, tl.lessonTitle from  teacherlessonhabit tlh  inner join teacherlesson tl on tlh.lessonId=tl.lessonId\n" +
            "              )l on pc.habitId=l.habitid \n" +
            "         left outer join \n" +
            "            (\n" +
            "             select putcardId, GROUP_CONCAT( DISTINCT s.nickname) as agrees from \n" +
            "\n" +
            "              putcardagree pa inner join  student s on pa.studentId=s.studentId\n" +
            "              group by putcardId     \n" +
            "             )pag on pc.id=pag.putcardId \n" +
            "                                \n" +
            "         where h.circleId='${circleId}'\n" +
            "         order by mm.maxPutCardTime desc   " +
            "         limit ${pageBegin},${pageSize} " +
            "</script>")
    public List<WxPutCardDiary> putCardDiaryList(@Param("circleId") String circleId, @Param("pageBegin") String pageBegin,@Param("pageSize") String pageSize);


    // 打卡点赞
    @Insert("<script>" +
            "  insert into putcardagree(putCardId,studentId) values(${putCardId},'${studentId}')" +
            "</script>")
    public int agreePutCard(@Param("putCardId") String putCardId ,@Param("studentId") String studentId);
}
