package com.yxp.eguodu.service.dic;

import com.yxp.eguodu.entity.CorpDuty;
import com.yxp.eguodu.entity.Habit;

import java.util.List;

public interface HabitService {
    public List<Habit> habitList();
    public int insertHabit(Habit habit);
    public int updateHabit(Habit habit);
    public int deleteHabit(String habitId);
}
