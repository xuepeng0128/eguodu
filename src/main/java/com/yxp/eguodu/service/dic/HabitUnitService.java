package com.yxp.eguodu.service.dic;

import java.util.List;
import java.util.Map;

public interface HabitUnitService {
    public List<Map<String,Object>> habitUnitList();
    public int insertHabitUnit(Map<String,Object> paras);
}
