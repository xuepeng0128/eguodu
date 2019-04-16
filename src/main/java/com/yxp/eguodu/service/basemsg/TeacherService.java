package com.yxp.eguodu.service.basemsg;

import com.yxp.eguodu.common.queryparams.TeacherQueryParams;
import com.yxp.eguodu.entity.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    public List<Map<String,Object>> teacherList(TeacherQueryParams paras);
    public List<Map<String,Object>> teacherListTotal(TeacherQueryParams paras);
    public int groupInsertTeachers(List<Teacher> teachers);
    public int insertTeacher(Teacher teacher);
    public int updateTeacher(Teacher teacher);
    public int deleteTeacher(String id);
}
