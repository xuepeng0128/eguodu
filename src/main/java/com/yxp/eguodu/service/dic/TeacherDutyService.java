package com.yxp.eguodu.service.dic;

import com.yxp.eguodu.entity.CorpDuty;
import com.yxp.eguodu.entity.TeacherDuty;

import java.util.List;

public interface TeacherDutyService {
    public List<TeacherDuty> teacherDutyList();
    public int insertTeacherDuty(TeacherDuty teacherDuty);
    public int updateTeacherDuty(TeacherDuty teacherDuty);
    public int deleteTeacherDuty(String teacherDutyId);
}
