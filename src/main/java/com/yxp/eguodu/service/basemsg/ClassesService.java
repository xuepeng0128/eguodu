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
    public int saveClassesTeacher(List<ClassesTeacher> classesTeachers);


    public int groupAddStuents(Map<String,Object> paras);

    public int insertClassesStudent(Map<String,Object> paras);

    public int updateClassesStudent(ClassesStudent classesStudent);

    public int classesStudentLeave(ClassesStudent classesStudent);

    public List<Classes> teacherAtClasses(Map<String,Object> paras);
}
