package com.yxp.eguodu.dao.dic;

import com.yxp.eguodu.entity.TeacherDuty;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherDutyMapper {


    @Select("select teacherDutyId ,teacherDutyName,master from dic_teacherduty")
    public List<TeacherDuty> teacherDutyList();
    @Insert("<script>" +
            "  insert into dic_teacherduty(teacherDutyId ,teacherDutyName,master) " +
            "  values (func_makeDicId('corpduty',''),#{teacherDutyName},#{master})" +
            "</script>")
    public int insertTeacherDuty(TeacherDuty teacherDuty);

    @Update("update dic_corpduty set teacherDutyName=#{teacherDutyName},master=#{master} where teacherDutyId=#{teacherDutyId}")
    public int updateTeacherDuty(TeacherDuty teacherDuty);
    @Delete("<script>" +
            " delete from dic_corpduty where teacherDutyId='${teacherDutyId}'" +
            "</script>")
    public int deleteTeacherDuty(String teacherDutyId);



}
