package com.yxp.eguodu.service.basemsg;

import com.yxp.eguodu.common.queryparams.ClassesQueryParams;
import com.yxp.eguodu.entity.Classes;
import com.yxp.eguodu.entity.ClassesStudent;
import com.yxp.eguodu.entity.ClassesTeacher;
import com.yxp.eguodu.entity.Student;

import java.util.List;
import java.util.Map;

public interface ClassesService {
    public List<Map<String,Object>> classesList(ClassesQueryParams params);
    public List<Map<String,Object>> classesListTotal(ClassesQueryParams params);

    public int insertClasses(Classes classes);
    public int updateClasses(Classes classes);
    public int deleteClasses(Map<String,Object> paras);

    public List<Map<String,Object>> classesTeacherList(Map<String,Object> paras);
    public int saveClassesTeacher(ClassesTeacher classesTeacher);


    public int groupAddStudents(List<Student> classesStudentList);
    public int insertClassesStudent(Student classesStudent);
    public int updateClassesStudent(Student classesStudent);
    public int classesStudentLeave(Student classesStudent);
    public int deleteClassesStudent(Map<String,Object> paras);

    public List<Map<String,Object>> studentAtClasses(Map<String,Object> paras);
    public List<Classes> teacherTeachedClasses(Map<String,Object> paras);
    public List<ClassesTeacher> subjectTeachersAtClasses(Map<String,Object> paras);
}
