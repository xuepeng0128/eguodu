package com.yxp.eguodu.serviceimp.basemsg;

import com.yxp.eguodu.common.queryparams.TeacherQueryParams;
import com.yxp.eguodu.dao.basemsg.TeacherMapper;
import com.yxp.eguodu.entity.Teacher;
import com.yxp.eguodu.service.basemsg.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherMapper mapper;
    @Override
    public List<Map<String, Object>> teacherList(TeacherQueryParams paras) {
        return mapper.teacherList(paras);
    }

    @Override
    public List<Map<String, Object>> teacherListTotal(TeacherQueryParams paras) {
        return mapper.teacherListTotal(paras);
    }

    @Override
    public int groupInsertTeachers(List<Teacher> teachers) {
        int d =0;
        d=mapper.groupInsertTeacher( teachers);
        return d;
    }

    @Override
    public int insertTeacher(Teacher teacher) {
        return mapper.insertTeacher(teacher);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return mapper.updateTeacher(teacher);
    }

    @Override
    public int deleteTeacher(String id) {
        return mapper.deleteTeacher(id);
    }
}
