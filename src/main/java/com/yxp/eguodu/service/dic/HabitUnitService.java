package com.yxp.eguodu.service.dic;

import com.yxp.eguodu.entity.HabitUnit;

import java.util.List;
import java.util.Map;

public interface HabitUnitService {
    public List<HabitUnit> habitUnitList();
    public int insertHabitUnit(Map<String,Object> paras);
}
