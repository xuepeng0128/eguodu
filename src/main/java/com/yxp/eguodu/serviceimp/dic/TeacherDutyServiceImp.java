package com.yxp.eguodu.serviceimp.dic;

import com.yxp.eguodu.dao.dic.TeacherDutyMapper;
import com.yxp.eguodu.entity.TeacherDuty;
import com.yxp.eguodu.service.dic.TeacherDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherDutyServiceImp implements TeacherDutyService {
    @Autowired
    private TeacherDutyMapper mapper;
    @Override
    public List<TeacherDuty> teacherDutyList() {
        return mapper.teacherDutyList();
    }

    @Override
    public int insertTeacherDuty(TeacherDuty teacherDuty) {
        return mapper.insertTeacherDuty(teacherDuty);
    }

    @Override
    public int updateTeacherDuty(TeacherDuty teacherDuty) {
        return mapper.updateTeacherDuty(teacherDuty);
    }

    @Override
    public int deleteTeacherDuty(String teacherDutyId) {
        return mapper.deleteTeacherDuty(teacherDutyId);
    }
}
