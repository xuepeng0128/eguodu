package com.yxp.eguodu.service.basemsg;

import com.yxp.eguodu.common.queryparams.StudentQueryParams;
import com.yxp.eguodu.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    public List<Map<String,Object>> studentList(StudentQueryParams paras);
    public List<Student>  studentListByOpenId( String openId);
    public Student bindStudentInviteCode( String inviteCode,String openId);
    public List<Map<String,Object>> studentListTotal(StudentQueryParams paras);

    public int groupInsertStudents(List<Student> students);
    public int insertStudent(Student student);
    public int updateStudent(Student student);
    public int deleteStudent(String id);
}
