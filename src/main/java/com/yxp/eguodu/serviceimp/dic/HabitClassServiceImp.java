package com.yxp.eguodu.serviceimp.dic;

import com.yxp.eguodu.dao.dic.HabitClassMapper;
import com.yxp.eguodu.entity.HabitClass;
import com.yxp.eguodu.service.dic.HabitClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitClassServiceImp implements HabitClassService {
    @Autowired
    private HabitClassMapper mapper;
    @Override
    public List<HabitClass> habitClassList() {
        return mapper.habitClassList();
    }

    @Override
    public int insertHabitClass(HabitClass habitClass) {
        return mapper.insertHabitClass(habitClass);
    }

    @Override
    public int updateHabitClass(HabitClass habitClass) {
        return mapper.updateHabitClass(habitClass);
    }

    @Override
    public int deleteHabitClass(String habitClassId) {
        return mapper.deleteHabitClass(habitClassId);
    }
}
