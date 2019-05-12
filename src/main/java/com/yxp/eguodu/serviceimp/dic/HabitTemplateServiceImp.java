package com.yxp.eguodu.serviceimp.dic;

import com.yxp.eguodu.dao.dic.HabitTemplateMapper;
import com.yxp.eguodu.entity.HabitTemplate;
import com.yxp.eguodu.service.dic.HabitTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HabitTemplateServiceImp implements HabitTemplateService {
    @Autowired
    private HabitTemplateMapper mapper;

    @Override
    public List<HabitTemplate> habitTemplateList(Map<String,Object> paras) {
        return mapper.habitTemplateList(paras);
    }

    @Override
    public List<Map<String, Object>> habitTemplateListTotal() {
        return mapper.habitTemplateListTotal();
    }

    @Override
    public int insertHabitTemplate(HabitTemplate habitTemplate) {
        return mapper.insertHabitTemplate(habitTemplate);
    }

    @Override
    public int updateHabitTemplate(HabitTemplate habitTemplate) {
        return mapper.updateHabitTemplate(habitTemplate);
    }

    @Override
    public int deleteHabitTemplate(Map<String, Object> paras) {
        return mapper.deleteHabitTemplate(paras);
    }
}
