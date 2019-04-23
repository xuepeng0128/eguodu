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
}
