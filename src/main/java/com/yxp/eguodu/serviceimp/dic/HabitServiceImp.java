package com.yxp.eguodu.serviceimp.dic;

import com.yxp.eguodu.dao.dic.HabitMapper;
import com.yxp.eguodu.entity.Habit;
import com.yxp.eguodu.service.dic.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitServiceImp implements HabitService {
    @Autowired
    private HabitMapper mapper;
    @Override
    public List<Habit> habitList() {
        return mapper.habitList();
    }

    @Override
    public int insertHabit(Habit habit) {
        return mapper.insertHabit(habit);
    }

    @Override
    public int updateHabit(Habit habit) {
        return mapper.updateHabit(habit);
    }

    @Override
    public int deleteHabit(String habitId) {
        return mapper.deleteHabit(habitId);
    }
}
