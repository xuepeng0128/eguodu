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

    @Delete("delete from habit where habitId='${habitId}'")
    public int deleteHabit(@Param("habitId") String habitId);

    @Insert("<script> " +
            "  insert into habitexam(habitExamId,teacherId,publishedDate,examTitle,examMemo,examBeginDate,examEndDate,totalScore) values(" +
            " #{habitExamId},#{teacherId},now(),#{examTitle},#{examMemo},#{examBeginDate},#{examEndDate},#{totalScore})" +
            " </script> ")
    public int insertHabitExam(HabitExam habitExam);

    // 根据习惯id获取考核
    @Select("<script>" +
            " select habitExamId,teacherId,publishedDate,examTitle,examMemo,examBeginDate,examEndDate,totalScore " +
            " from habitexam where habitExamId in (SELECT habitExamId from habit where habitId='${habitId}')" +
            "</script>")
    public List<HabitExam> habitExamByHabitId(@Param("habitId") String habitId);

    //查询考核下的习惯
    @Select("<script>" +
            "  SELECT habitId,circleId,habitClassId,subHabitClassId,icon,color,habitName, " +
            "       memo,picUrl,pirTime,timeUnit,`mode`,timeModeNum,timeCompare,countModeNum, " +
            "       valueModeNum,unitName,guoduCoin,score,habitExamId,buildTime,buildTeacherId, " +
            "       buildStudentId,putCardBeginDate,putCardEndDate " +
            "  from habit where habitExamId='${habitExamId}' " +
            "</script>")
    public List<Habit> examHabits(@Param("habitExamId") String habitExamId);



    @Delete("delete from habitexam where habitExamId='${habitExamId}'")
    public int deleteHabitExam(@Param("habitExamId") String habitExamId);


    // 查询习惯下学生打卡情况
    @Select("<script>" +
            " SELECT al.studentId,al.studentName ,al.shouldputCards ,ifnull(puted.havePutCards,0) as havePutCards , " +
            "       ifnull(puted.haveGuodubi,0) as haveGuodubi, ifnull(puted.haveScore,0) as haveScore ," +
            "       ifnull(puted.finished,0) as finished  from  " +
            "( " +
            " select s.studentId, t.studentName, count(1) as shouldPutCards   from studentputcard s inner join student t on s.studentId=t.studentId " +
            " where s.habitid='${habitId}'  group by  s.studentId, t.studentName " +
            " ) al left outer join ( " +
            " select s.studentId, t.studentName, count(1) as havePutCards ,sum(haveGuodubi) as haveGuodubi ,sum(haveScore) as haveScore ," +
            " sum(finished) as finished from studentputcard s inner join student t on s.studentId=t.studentId " +
            "  where habitid='${habitId}' and putCardTime is not null " +
            "group by  s.studentId, t.studentName " +
            ")puted on al.studentId=puted.studentId " +
            "   limit ${pageBegin},${pageSize} " +
            "</script>")
    public List<Map<String,Object>> habitStudentPutCards(@Param("habitId") String habitId ,@Param("pageBegin") String pageBegin , @Param("pageSize") String pageSize);

    @Select("<script>" +
            " SELECT p.*,a.agrees from studentputcard p left outer join ( select putCardId, count(1) as agrees from  putcardagree group by putCardId )a on p.id=a.putCardId\n" +
            " where habitId='${habitId}' and studentId='${studentId}' " +
            " limit ${pageBegin},${pageSize}" +
            "</script>")
    public List<Map<String,Object>> currentStudentPutCardList(@Param("habitId") String habitId, @Param("studentId") String studentId,@Param("pageBegin") String pageBegin , @Param("pageSize") String pageSize);

    @Insert("<script> insert into habitstudent(habitId,studentId,joinTime) values(" +
            " #{habitId},#{studentId},now())" +
            " </script>")
    public int insertHabitStudent(HabitStudent habitStudent);

    @Delete("delete from habitexam where habitExamId='${habitExamId}'")
    public int deleteHabitStudent(@Param("habitId") String habitId);



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



    // 获取习惯参加学生

    @Select("<script>" +
            " select stu.* from habitstudent h inner join student stu on h.studentId=stu.studentId  " +
            "and stu.schoolId='${schoolId}' " +
            "where h.habitId='${habitId}' " +
            "</script>")
    public List<Student> habitStudents(@Param("habitId") String habitId ,@Param("schoolId") String schoolId);



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
            "     select pc.id, stu.nickname, stu.headimg,stu.sex, putCardaudioUrls,putCardMemo,putCardPicUrls,putCardvideoUrls,putCardTime ," +
            "         case when mm.maxPutCardTime is null then 0 else " +
            "             TimeStampDiff(DAY,mm.minPutCardTime,mm.maxPutCardTime) +1" +
            "         end  as holdDays ," +
            "         ifnull(l.lessonTitle,'') as lessonTitle ," +
            "         ifnull(pag.agrees,'') as agrees " +
            "         from (" +
            "                 select pi.* from  " +
            "                   (SELECT * from  studentputcard  where putCardTime is not null)  pi " +
//            "                    inner join " +
//            "                   (" +
//            "                      SELECT habitid,studentId, max(putCardTime) as maxPutCardTime from studentputcard GROUP BY habitId ,studentId " +
//            "                  <![CDATA[     having  DATEDIFF(now(),max(putCardTime))>=0 ]]> " +
//            "                    )px on pi.habitid =px.habitid and pi.studentid =px.studentId and pi.putcardTime=px.maxPutCardTime" +
            "              ) pc" +
            "" +
            " " +
            "           inner join student stu on pc.studentId =stu.studentId and stu.endTime is null " +
            "           inner join habit h on pc.habitId=h.habitId " +
            "         left outer join  (" +
            "                 select studentId , habitId, max(putCardTime) as maxPutCardTime ," +
            "                                             min(putCardTime) as minPutCardTime " +
            "                  from studentputcard group by studentId,habitId" +
            "                  )mm on pc.habitId=mm.habitId and pc.studentId=mm.studentId " +
            "         left outer join (  " +
            "               select tlh.habitid, tl.lessonTitle from  teacherlessonhabit tlh  inner join teacherlesson tl on tlh.lessonId=tl.lessonId" +
            "              )l on pc.habitId=l.habitid " +
            "         left outer join " +
            "            (" +
            "             select putcardId, GROUP_CONCAT( DISTINCT s.nickname) as agrees from " +
            "" +
            "              putcardagree pa inner join  student s on pa.studentId=s.studentId" +
            "              group by putcardId     " +
            "             )pag on pc.id=pag.putcardId " +
            "                                " +
            "         where 1=1" +
            " <if test='circleId != null and circleId !=\"\"'>" +
            "    and h.circleId='${circleId}'" +
            " </if >" +
            " <if test='longitude != null and longitude !=\"\" and latitude != null and latitude !=\"\"'>" +
            " and  longitude is not null and  latitude is not null  " +
            " and    ROUND(" +
            "        6378.138 * 2 * ASIN(" +
            "            SQRT(" +
            "                POW(" +
            "                    SIN(" +
            "                        (" +
            "                            ${latitude} * PI() / 180 - latitude * PI() / 180" +
            "                        ) / 2" +
            "                    )," +
            "                    2" +
            "                ) + COS(${latitude} * PI() / 180) * COS(latitude * PI() / 180) * POW(" +
            "                    SIN(" +
            "                        (" +
            "                            ${longitude} * PI() / 180 - longitude * PI() / 180" +
            "                        ) / 2" +
            "                    )," +
            "                    2" +
            "                )" +
            "            )" +
            "        ) * 1000" +
            " <![CDATA[   ) <=8000  ]]>" +
            " </if> " +
            " <if test='putCardTimeBegin != null and putCardTimeBegin !=\"\" '>" +
            "   <![CDATA[   and putCardTime >= '${putCardTimeBegin}'  ]]>" +
            " </if> " +
            " <if test='putCardTimeEnd != null and putCardTimeEnd !=\"\" '>" +
            "   <![CDATA[   and putCardTime <= '${putCardTimeEnd}'  ]]>" +
            " </if> " +
            " order by " +
            " <if test='mostAgree ==\"1\"'> " +
            "   LENGTH(ifnull(pag.agrees, '')) desc, " +
            " </if>  " +
            " <if test='mostHoldDays ==\"1\"'> " +
            "   case  " +
            " WHEN mm.maxPutCardTime IS NULL THEN " +
            " 0 " +
            " ELSE " +
            " TimeStampDiff( " +
            " DAY, " +
            " mm.minPutCardTime, " +
            " mm.maxPutCardTime " +
            " ) + 1  END desc ," +
            " </if>" +
            "         putCardTime desc   " +
            "         limit ${pageBegin},${pageSize} " +
            "</script>")
    public List<WxPutCardDiary> putCardDiaryList(@Param("circleId") String circleId,@Param("longitude") String longitude ,
                                                 @Param("latitude") String latitude, @Param("mostHoldDays") String mostHoldDays,
                                                 @Param("mostAgree") String mostAgree,@Param("putCardTimeBegin") String putCardTimeBegin ,
                                                 @Param("putCardTimeEnd") String putCardTimeEnd, @Param("pageBegin") String pageBegin,
                                                 @Param("pageSize") String pageSize);


    // 打卡点赞
    @Insert("<script>" +
            "  insert into putcardagree(putCardId,studentId) values(${putCardId},'${studentId}')" +
            "</script>")
    public int agreePutCard(@Param("putCardId") String putCardId ,@Param("studentId") String studentId);


  // 课程id关联习惯

    @Select("<script>" +
            "   select h.habitId,cla.grade, cla.classes ,  h.circleId,c.circleTitle,h.habitClassId ,p.habitClassName,h.subHabitClassId,s.habitClassName " +
            "       as subHabitClassName ,h.icon,h.color,h.habitName,h.memo,h.picUrl,h.pirTime,h.timeUnit,h.`mode`,h.timeModeNum, h.timeCompare," +
            "      h.countModeNum,h.valueModeNum,h.unitName,guoduCoin,h.score,h.habitExamId,e.examTitle , e.totalScore ," +
            "    h.buildTeacherId,h.buildStudentId,h.buildTime,h.putCardBeginDate,h.putCardEndDate,ifnull(stu.joinStudents,0) as joinStudents " +
            "  from habit h inner join circle c on h.circleId=c.circleId  " +
            "inner join dic_habitclass p on h.habitClassId=p.habitClassId  inner join dic_habitclass s on h.subHabitClassId " +
            " =s.habitClassId left outer join habitexam e on h.habitExamId=e.habitExamId  left outer join classes cla on c.classesId=cla.classesId" +
            " left outer join (select habitId , count(studentId) as joinStudents from habitstudent group by habitId  )stu on h.habitId=stu.habitId " +
            "where h.habitId in (select habitId from teacherlessonhabit where lessonId='${lessonId}') " +
            "</script>")
    public List<Habit> lessonTohabitList(@Param("lessonId") String lessonId);



}
