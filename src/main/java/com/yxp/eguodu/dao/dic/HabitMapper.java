package com.yxp.eguodu.dao.dic;

import com.yxp.eguodu.entity.CorpDuty;
import com.yxp.eguodu.entity.Habit;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HabitMapper {


    @Select("select h.habitId ,h.habitName,h.habitClassId,pc.habitClassName, h.subHabitClassId,c.habitClassName as subHabitClassName," +
            " h.memo ,h.picUrl from dic_habit h inner join " +
            " dic_habitclass pc on h.habitClassId=pc.habitClassId inner join dic_habitclass c on h.subHabitClassId=c.habitClassId" +
            " ")
    public List<Habit> habitList();




    @Insert("<script>" +
            "  insert into dic_habit(habitId ,habitName,habitClass,memo) " +
            "  values (func_makeDicId('habit',''),'${habitName}',${habitClass},'${memo}')" +
            "</script>")
    public int insertHabit(Habit habit);

    @Update("update dic_habit set habitName='${habitName}',habitClass=${habitClass},memo='${memo}' where habitId='${habitId}'")
    public int updateHabit(Habit habit);
    @Delete("<script>" +
            " delete from dic_habit where habitId='${habitId}'" +
            "</script>")
    public int deleteHabit(String habitId);


}
