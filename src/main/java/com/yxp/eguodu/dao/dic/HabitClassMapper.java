package com.yxp.eguodu.dao.dic;

import com.yxp.eguodu.entity.CorpDuty;
import com.yxp.eguodu.entity.HabitClass;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HabitClassMapper {


    @Select("select habitClassId ,habitClassName,pareHabitClassId from dic_habitclass")
    public List<HabitClass> habitClassList();
    @Insert("<script>" +
            "  insert into dic_habitclass(habitClassId ,habitClassName,pareHabitClassId) " +
            "  values (func_makeDicId('habitclass','${pareHabitClassId}'),'${habitClassName}','${pareHabitClassId}')" +
            "</script>")
    public int insertHabitClass(HabitClass habitClass);

    @Update("update dic_habitclass set habitClassName='${habitClassName}',pareHabitClassId='${pareHabitClassId}' where habitClassId='${habitClassId}'")
    public int updateHabitClass(HabitClass habitClass);
    @Delete("<script>" +
            " delete from dic_habitclass where habitClassId='${habitClassId}'" +
            "</script>")
    public int deleteHabitClass(String habitClassId);





}
