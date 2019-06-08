package com.yxp.eguodu.serviceimp.basemsg;

import com.yxp.eguodu.common.queryparams.StudentQueryParams;
import com.yxp.eguodu.dao.basemsg.StudentMapper;
import com.yxp.eguodu.entity.Student;
import com.yxp.eguodu.service.basemsg.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentMapper mapper;
    @Override
    public List<Map<String, Object>> studentList(StudentQueryParams paras) {
        return mapper.studentList(paras);
    }

    @Override
    public List<Student> studentListByOpenId(String openId) {
        return mapper.studentListByOpenId(openId);
    }

    @Override
    public Student bindStudentInviteCode(String inviteCode, String openId) {
        List<Student> students= mapper.studentListByInviteCode(inviteCode);
        if(students == null || students.size()==0){
            return null;
        }

        else {
            Student student= students.get(0);
            mapper.addStudentOpenId(student.getId(),openId);
            return student;
        }
    }

    @Override
    public List<Map<String, Object>> studentListTotal(StudentQueryParams paras) {
        List<Map<String, Object>> list =mapper.studentListTotal(paras);
        return list;
    }

    @Override
    public int groupInsertStudents(List<Student> students) {
        return mapper.groupInsertStudent(students);
    }

    @Override
    public int insertStudent(Student student) {
        return mapper.insertStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return mapper.updateStudent(student);
    }

    @Override
    public int deleteStudent(String id) {
        return mapper.deleteStudent(id);
    }

    @Override
    public String studentUnbindWx(String openId, String studentId) {
        mapper.studentUnbindWx(openId,studentId);
        List<Map<String,Object>> list = mapper.studentInviteCodeById(studentId);
        if(list != null && list.size()>0)
        {
            return  list.get(0).get("inviteCode").toString();
        }else{
            return "";
        }
    }


}
