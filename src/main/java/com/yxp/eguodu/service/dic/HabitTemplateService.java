package com.yxp.eguodu.service.dic;

import com.yxp.eguodu.entity.HabitTemplate;

import java.util.List;
import java.util.Map;

public interface HabitTemplateService {
    public List<HabitTemplate> habitTemplateList(Map<String,Object> paras);
    public List<Map<String,Object>> habitTemplateListTotal();
    public int insertHabitTemplate(HabitTemplate habitTemplate);
    public int updateHabitTemplate(HabitTemplate habitTemplate);
    public int deleteHabitTemplate(Map<String,Object> paras);
}
