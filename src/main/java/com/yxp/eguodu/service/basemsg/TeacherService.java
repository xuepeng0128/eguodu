package com.yxp.eguodu.service.basemsg;

import com.yxp.eguodu.common.queryparams.TeacherQueryParams;
import com.yxp.eguodu.entity.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    public List<Map<String,Object>> teacherList(TeacherQueryParams paras);
    public List<Map<String,Object>> teacherListTotal(TeacherQueryParams paras);
    public int groupInsertTeachers(List<Teacher> teachers) throws Exception;
    public int insertTeacher(Teacher teacher) throws Exception;
    public int updateTeacher(Teacher teacher);
    public int deleteTeacher(Map<String,Object> paras);
    public int quitDuty(Map<String,Object> paras);
}
