package com.yxp.eguodu.dao.business;

import com.yxp.eguodu.common.queryparams.CircleQueryParams;
import com.yxp.eguodu.entity.Circle;
import org.apache.ibatis.annotations.*;

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


    @Insert("<script>" +
            "  insert into circle(circleId,circleTitle,subTitle,circleClassId,schoolId,classesId,buildTeacherId,buildTime,memo,picUrl,circleProperty)" +
            "   values(func_makeBusinessId('circle',#{schoolId}) ,#{circleTitle},#{subTitle},#{circleClassId},#{schoolId｝,#{classesId},#{buildTeacherId}," +
            "   #{buildTime},#{memo},#{picUrl},#{circleProperty} )" +
            " </script>")
   public int insertCircle(Circle circle);

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

}
