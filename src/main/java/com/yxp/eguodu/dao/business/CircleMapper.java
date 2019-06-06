package com.yxp.eguodu.dao.business;

import com.yxp.eguodu.common.queryparams.CircleQueryParams;
import com.yxp.eguodu.entity.Circle;
import com.yxp.eguodu.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
public interface CircleMapper {

    @Select("<script> " +
            " select c.circleId,c.circleTitle,c.subTitle,c.circleClassId,cc.circleClassName,c.schoolId ,sh.schoolName,c.classesId,cla.grade," +
            "   cla.classes ,cla.classesName, c.buildTeacherId,t.teacherName as buildTeacherName,c.buildTime ,c.memo,c.picUrl,c.closeMan,c.closeTime ,c.closeReason ," +
            "    c.circleProperty from circle c inner join dic_circleclass cc on c.circleClassId=cc.circleClassId " +
            "   inner join school sh on c.schoolId=sh.schoolId left outer join classes cla on c.classesId = cla.classesId " +
            "   inner join teacher t on c.buildTeacherId=t.teacherId " +
            "   where 1=1   and c.closeMan is null  " +
            " <if test='circleTitle!=null and circleTitle !=\"\"'>" +
            "    and c.circleTitle like '%${circleTitle}%'" +
            " </if>" +
            " <if test='schoolId!=null and schoolId !=\"\" and schoolId !=\"0\"'>" +
            "    and c.schoolId = '${schoolId}' " +
            " </if>" +
            " <if test='schoolName!=null and schoolName !=\"\" '>" +
            "    and cla.schoolName like '%${schoolName}%' " +
            " </if>" +
            " <if test='classesId!=null and classesId !=\"\" and classesId !=\"0\" '>" +
            "    and c.classesId = '${classesId}' " +
            " </if>" +
            " <if test='grade!=null and grade !=\"\" and grade !=\"0\" '>" +
            "    and cla.grade = ${grade} " +
            " </if>" +
            " <if test='classes!=null and classes !=\"\" and classes !=\"0\" '>" +
            "    and cla.classes = ${classes} " +
            " </if>" +
            " <if test='classesName!=null and classesName !=\"\" '>" +
            "    and cla.classesName like  '%${classesName}%' " +
            " </if>" +
            " <if test='buildTeacherId!=null and buildTeacherId !=\"\" and buildTeacherId != \"0\"'>" +
            "    and c.buildTeacherId =  '${buildTeacherId}' " +
            " </if>" +
            " <if test='buildTeacherName!=null and buildTeacherName !=\"\" '>" +
            "    and t.teacherName like  '%${buildTeacherName}%' " +
            " </if>" +
            " <if test='buildTimeBegin!=null and buildTimeBegin !=\"\" '>" +
            " <![CDATA[  and c.buildTime >=  '${buildTimeBegin}' ]]>" +
            " </if>" +
            " <if test='buildTimeEnd!=null and buildTimeEnd !=\"\" '>" +
            " <![CDATA[  and c.buildTime <=  '${buildTimeEnd}' ]]>" +
            " </if>" +
            " limit ${pageBegin},${pageSize}" +
            "</script>")
    public List<Map<String ,Object>> circleList(CircleQueryParams circleQueryParams);

    @Select("<script> " +
            " select count(*) as total from circle c inner join dic_circleclass cc on c.circleClassId=cc.circleClassId " +
            "   inner join school sh on c.schoolId=sh.schoolId left outer join classes cla on c.classesId = cla.classesId " +
            "   inner join teacher t on c.buildTeacherId=t.teacherId " +
            "   where 1=1  and c.closeMan is null  " +
            " <if test='circleTitle!=null and circleTitle !=\"\"'>" +
            "    and c.circleTitle like '%${circleTitle}%'" +
            " </if>" +
            " <if test='schoolId!=null and schoolId !=\"\" and schoolId !=\"0\"'>" +
            "    and c.schoolId = '${schoolId}' " +
            " </if>" +
            " <if test='schoolName!=null and schoolName !=\"\" '>" +
            "    and cla.schoolName like '%${schoolName}%' " +
            " </if>" +
            " <if test='classesId!=null and classesId !=\"\" and classesId !=\"0\" '>" +
            "    and c.classesId = '${classesId}' " +
            " </if>" +
            " <if test='grade!=null and grade !=\"\" and grade !=\"0\" '>" +
            "    and cla.grade = ${grade} " +
            " </if>" +
            " <if test='classes!=null and classes !=\"\" and classes !=\"0\" '>" +
            "    and cla.classes = ${classes} " +
            " </if>" +
            " <if test='classesName!=null and classesName !=\"\" '>" +
            "    and cla.classesName like  '%${classesName}%' " +
            " </if>" +
            " <if test='buildTeacherId!=null and buildTeacherId !=\"\" and buildTeacherId != \"0\"'>" +
            "    and c.buildTeacherId =  '${buildTeacherId}' " +
            " </if>" +
            " <if test='buildTeacherName!=null and buildTeacherName !=\"\" '>" +
            "    and t.teacherName like  '%${buildTeacherName}%' " +
            " </if>" +
            " <if test='buildTimeBegin!=null and buildTimeBegin !=\"\" '>" +
            " <![CDATA[  and c.buildTime >=  '${buildTimeBegin}' ]]>" +
            " </if>" +
            " <if test='buildTimeEnd!=null and buildTimeEnd !=\"\" '>" +
            " <![CDATA[  and c.buildTime <=  '${buildTimeEnd}' ]]>" +
            " </if>" +
            "</script>")
   public List<Map<String,Object>> circleListTotal(CircleQueryParams circleQueryParams);

   @Select("<script>" +
           "  select stu.studentId,stu.studentPaperId,stu.studentName,stu.sex,stu.birthday,stu.tel,stu.address,stu.schoolId,stu.wxCode,stu.headimg,stu.nickName,stu.regTime,stu.endTime  \n" +
           "from circlestudent cs inner join circle c on cs.circleId=c.circleId inner join student stu on c.schoolId=stu.schoolId and cs.studentId=stu.studentId\n" +
           "where c.circleId='${circleId}'" +
           "</script>")
    public List<Student> circleStudentList(@Param("circleId") String circleId);

   @Select("<script>" +
           "   select c.circleId,c.circleTitle,c.subTitle,c.circleClassId,c.schoolId,c.classesId,c.buildTeacherId,c.buildTime,c.memo,c.picUrl,c.circleProperty\n" +
           " from circle c  inner join circleteacher ct on c.circleId=ct.circleId\n" +
           "where ct.teacherId='${teacherId}'" +
           "</script>")
   public List<Circle> teacherJoinedCircles(@Param("teacherId") String teacherId);

    @Insert("<script>" +
            "  insert into circle(circleId,circleTitle,subTitle,circleClassId,schoolId,classesId,buildTeacherId,buildStudentId,buildTime,memo,picUrl,circleProperty)" +
            "   values(#{circleId} ,#{circleTitle},#{subTitle},#{circleClassId},#{schoolId},#{classesId},#{buildTeacherId},#{buildStudentId}," +
            "   now(),#{memo},#{picUrl},#{circleProperty} )" +
            " </script>")
   public int insertCircle(Circle circle);

    // 插入班级学生到圈子
    @Insert("<script>" +
            "  insert into circlestudent(circleId,studentId,regTime)\n" +
            "  select '${circleId}',studentId, now() from classesstudent where classesId='${classesId}'" +
            "</script>")
    public int insertClassStudentToCircle(@Param("circleId") String circleId,@Param("classesId") String classesId);

    //插入某一学生到圈子
    @Insert("<script>" +
            "  insert into circlestudent(circleId,studentId,regTime) " +
            " values( '${circleId}','${studentId}', now() ) " +
            "</script>")
    public int insertCurrentStudentToCircle(@Param("circleId") String circleId,@Param("studentId") String studentId);


    // 某学生退出圈子
    // 学生退出圈子
    @Update("<script>" +
            "  update circlestudent set leaveTime= now() where circleId='${circleId}' and studentId='${studentId}' and leaveTime is null  " +
            "</script>")
    public int  studentOutOfCircle(@Param("circleId") String circleId, @Param("studentId") String studentId);


    @Insert("<script>" +
            "   insert into circleteacher(circleId, teacherId) " +
            "  select '${circleId}' as circleId, buildTeacherId from circle where circleId='${circleId}' " +
            "     UNION " +
            "  select '${circleId}' as circleId, teacherId from  classesteacher where classesId='${classesId}'" +
            "</script>")
    public int insertTeachersToCircle(@Param("circleId") String circleId,@Param("classesId") String classesId);

    @Update(" update circle set circleTitle=#{circleTitle},subTitle=#{subTitle},circleClassId=#{circleClassId}," +
            "  memo=#{memo},picUrl=#{picUrl},circleProperty=#{circleProperty} where circleId=#{circleId}")
    public int updateCircle(Circle circle);

    @Delete("<script> " +
            "  delete from circle where circleId =#{circleId}" +
            "</script>")
    public int deleteCircle(Map<String,Object> paras);

    @Update("<script>" +
            " update circle set  closeMan =#{closeMan} , closeTime = now() , closeReason=#{closeReson} where circleId=#{circleId}   " +
            "</script>")
    public int closeCircle(Map<String,Object> paras);




// -----------------------------------微信-----------------------------------------//

   //按条件组合分页查询圈子(本学生未加入过的公开圈子)
   @Select("<script>" +
           " select circleId,circleTitle,subTitle,c.circleClassId, ccs.circleClassName, c.schoolId,ifnull(sc.schoolName,'') as schoolName, " +
           "       classesId,buildTeacherId,ifnull(te.teacherName,'') as buildTeacherName, buildStudentId, ifnull(stu.studentName,'') as buildStudentName , " +
           "       buildTime,c.memo,picUrl " +
           " from circle c inner join dic_circleclass ccs on c.circleClassId=ccs.circleClassId left outer join school sc on c.schoolId=sc.schoolId  left outer join teacher te on  " +
           " c.buildTeacherId = te.teacherId left outer join (select distinct studentId ,studentName from student) stu on c.buildStudentId= stu.studentId " +
           " where circleProperty=2 and closeTime is null  " +
           " <if test='circleTitle != null and circleTitle !=\"\" '>" +
           " and c.circleTitle like '%${circleTitle}%' " +
           " </if> " +
           " <if test='circleClassId != null and circleClassId !=\"\"  and circleClassId !=\"0\" ' >" +
           " and c.circleClassId='${circleClassId}' " +
           " </if> " +
           " and c.circleid not in (select DISTINCT circleId from circlestudent where leavetime is  null and studentId='${studentId}' ) " +
           " limit ${pageBegin},${pageSize}" +
           "</script>")
   public List<Map<String ,Object>>  circleFindList(@Param("circleTitle") String circleTitle,@Param("circleClassId") String circleClassId,
                                                    @Param("studentId") String studentId,@Param("pageSize") String pageSize,@Param("pageBegin") String pageBegin);


    // 查询本学生当前加入的圈子

    @Select("<script>" +
            " select circleId,circleTitle,subTitle,c.circleClassId, ccs.circleClassName,c.schoolId,ifnull(sc.schoolName,'') as schoolName, " +
            "       classesId,buildTeacherId,ifnull(te.teacherName,'') as buildTeacherName, buildStudentId, ifnull(stu.studentName,'') as buildStudentName , " +
            "       buildTime, c.memo,picUrl,closeMan,closeTime,closeReason,circleProperty  " +
            " from circle c  inner join dic_circleclass ccs on c.circleClassId=ccs.circleClassId left outer join school sc on c.schoolId=sc.schoolId  left outer join teacher te on  " +
            " c.buildTeacherId = te.teacherId left outer join (select distinct studentId ,studentName from student) stu on c.buildStudentId= stu.studentId " +
            " where 1=1 " +
            " and c.circleid  in (select DISTINCT circleId from circlestudent where 1=1 " +
            "  and leavetime is  null and studentId='${studentId}' ) " +
            " limit ${pageBegin},${pageSize}" +
            "</script>")
    public List<Map<String,Object>> circleHaveJoinedList(@Param("studentId") String studentId, @Param("pageSize") String pageSize,@Param("pageBegin") String pageBegin);

    // 查询本学生家长建的圈子
    @Select("<script>" +
            "   select circleId,circleTitle,subTitle,c.circleClassId, ccs.circleClassName,   buildTime, c.memo,picUrl,closeMan,closeTime,closeReason,circleProperty " +
            "    from circle c inner join dic_circleclass ccs on c.circleClassId=ccs.circleClassId   where  buildStudentId='${studentId}' " +
            " limit ${pageBegin},${pageSize}" +
            "</script>")
    public List<Map<String,Object>>  studentBuildCircleList(@Param("studentId") String studentId, @Param("pageSize") String pageSize,
                                                             @Param("pageBegin") String pageBegin);





   // 根据id 查询
   @Select("<script>" +
           " select circleTitle,subTitle,picUrl,c.schoolId, sc.schoolName ,ifnull(cs.joinStudents,0) as joinStudents ," +
           " ifnull(ssp.totalputCards,0) as totalputCards,ifnull(notice.memo,'') as information, " +
           "  case when joinc.circleId is null then 0 else 1 end as haveJoined  from circle c \n" +
           "inner join " +
           "( select circleId, count(*) as joinStudents from  circlestudent group by circleId)  cs on c.circleId =cs.circleId " +
           "left outer JOIN school sc on c.schoolId =sc.schoolId left OUTER join  " +
           "( " +
           "  select '${circleId}' as circleId,  count(*) as totalputCards  from  " +
           "     ( " +
           "          select * from studentputcard where putCardTime is not null  " +
           "     ) sp inner join habit ha on sp.habitId=ha.habitId inner join circle cir on ha.circleId=cir.circleId where cir.circleId='${circleId}' " +
           ")ssp on c.circleId=ssp.circleId " +
           " left outer join ( " +
           "  select sendCircleIds,memo from teachernotice where sendCircleIds='${circleId}' ORDER BY buildDate desc limit 1 " +
           ")notice  on c.circleId=notice.sendCircleIds  left outer join ( " +
           "   select circleId,studentId from circlestudent where circleId='${circleId}' and studentId='${studentId}' and leavetime is  null " +
           ") joinc on c.circleId= joinc.circleId " +
           "where c.circleId='${circleId}' " +
           "</script>")
    public List<Map<String,Object>> circleMsgById(@Param("circleId") String circleId,@Param("studentId") String studentId);


   // 根据id获取圈子简介
   @Select("<script>" +
           " select memo from circle where circleId='${circleId}'" +
           "</script>")
   public List<Map<String,Object>> circleMemo(@Param("circleId") String circleId);



}
