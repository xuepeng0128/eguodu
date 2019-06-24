package com.yxp.eguodu.serviceimp.basemsg;

import com.yxp.eguodu.common.DesUtil;
import com.yxp.eguodu.common.queryparams.TeacherQueryParams;
import com.yxp.eguodu.dao.system.UserMapper;
import com.yxp.eguodu.entity.Teacher;
import com.yxp.eguodu.entity.User;
import com.yxp.eguodu.service.basemsg.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.yxp.eguodu.dao.basemsg.TeacherMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherMapper mapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<Map<String, Object>> teacherList(TeacherQueryParams paras) {
        return mapper.teacherList(paras);
    }

    @Override
    public List<Teacher> teacherListByOpenId(String openId) {
        return mapper.teacherListByOpenId(openId);
    }

    @Override
    public List<Map<String, Object>> teacherListTotal(TeacherQueryParams paras) {
        return mapper.teacherListTotal(paras);
    }

    @Override
    public int groupInsertTeachers(List<Teacher> teachers) throws Exception {
        int d =0;
        d=mapper.groupInsertTeacher( teachers);

        List<Teacher> tlist = mapper.teacherNoInUser(new HashMap<String,Object>(){{
            put("schoolId",teachers.get(0).getSchoolId());
        }});
        for (Teacher t : tlist)
        {
            User user = new User( "",t.getTel(),DesUtil.encrypt("123456"),t.getSchoolId(),
                    null,null,t.getTeacherId(),false,false,null,2);
            userMapper.insertUser(user);
        }
        return 1;
    }

    @Override
    public int insertTeacher(Teacher teacher) throws Exception {

        mapper.insertTeacher(teacher);
        List<Teacher> tlist = mapper.teacherNoInUser(new HashMap<String,Object>(){{
            put("schoolId",teacher.getSchoolId());
        }});
        for (Teacher t : tlist)
        {


            User user = new User( "",t.getTel(),DesUtil.encrypt("123456"),t.getSchoolId(),
                    null,null,t.getTeacherId(),false,false,null,2);
            userMapper.insertUser(user);
        }
        return 1;
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return mapper.updateTeacher(teacher);
    }

    @Override
    public int deleteTeacher(Map<String,Object> paras) {
        mapper.deleteTeacher(paras);
        return userMapper.deleteUserByTeacherId(paras);
    }

    @Override
    public int quitDuty(Map<String, Object> paras) {
         mapper.quitDuty(paras);
        return userMapper.deleteUserByTeacherId(paras);
    }
}
