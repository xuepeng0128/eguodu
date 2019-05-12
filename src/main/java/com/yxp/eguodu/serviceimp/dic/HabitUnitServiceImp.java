package com.yxp.eguodu.serviceimp.dic;

import com.yxp.eguodu.dao.dic.HabitUnitMapper;
import com.yxp.eguodu.entity.HabitUnit;
import com.yxp.eguodu.service.dic.HabitUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HabitUnitServiceImp implements HabitUnitService {
    @Autowired
    private HabitUnitMapper mapper;
    @Override
    public List<HabitUnit> habitUnitList() {
        return mapper.habitUnitList();
    }

    @Override
    public int insertHabitUnit(Map<String, Object> paras) {
        mapper.deleteHabitUnit(paras);
        return mapper.insertHabitUnit(paras);
    }
}
