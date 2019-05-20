package com.yxp.eguodu.service.business;

import com.yxp.eguodu.common.queryparams.HabitQueryParams;
import com.yxp.eguodu.entity.Habit;
import com.yxp.eguodu.entity.HabitExam;
import com.yxp.eguodu.entity.HabitStudent;
import com.yxp.eguodu.entity.StudentPutCard;
import java.util.List;
import java.util.Map;

public interface HabitService {


    public List<Habit> habitList(HabitQueryParams habitQueryParams);

    public List<Map<String,Object>> habitListTotal(HabitQueryParams habitQueryParams);


    public int insertExamHabit(HabitExam habitExam ,List<Habit> habits,String[] studentIds);

    public int insertNoExamHabit(Habit habit,String[] studentIds);

    public int studentPutCard( String habitId ,  String studentId);

}
