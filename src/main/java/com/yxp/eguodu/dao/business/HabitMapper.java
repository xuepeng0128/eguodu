package com.yxp.eguodu.dao.business;

import com.yxp.eguodu.entity.Habit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HabitMapper {

@Select("<script>" +
        "   select habitId, h.circleId,c.circleTitle,h.habitClassId ,p.habitClassName,h.subHabitClassId,s.habitClassName " +
        "       as subHabitClassName ,h.icon,h.color,h.habitName,h.memo,h.picUrl,h.pirTime,h.timeUnit,h.`mode`,h.timeModeNum, " +
        "      h.countModeNum,h.valueModeNum,h.unitName,guoduCoin,h.score,h.putCardExamId,h.buildTeacherId,h.buildStudentId,h.buildTime " +
        "  from habit h inner join circle c on h.circleId=c.circleId " +
        "inner join dic_habitclass p on h.habitClassId=p.habitClassId  inner join dic_habitclass s on h.subHabitClassId " +
        "=s.habitClassId " +
        "where 1=1" +
        "</script>")
    public List<Habit> habitList();




}
