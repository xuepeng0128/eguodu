package com.yxp.eguodu.service.dic;

import com.yxp.eguodu.entity.HabitClass;

import java.util.List;

public interface HabitClassService {

     public List<HabitClass> habitClassList();

    public int insertHabitClass(HabitClass habitClass);

     public int updateHabitClass(HabitClass habitClass);
       public int deleteHabitClass(String habitClassId);
}
