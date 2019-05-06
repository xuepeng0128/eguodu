package com.yxp.eguodu.serviceimp.basemsg;

import com.yxp.eguodu.common.queryparams.ClassesQueryParams;
import com.yxp.eguodu.dao.basemsg.ClassesMapper;
import com.yxp.eguodu.dao.basemsg.StudentMapper;
import com.yxp.eguodu.entity.Classes;
import com.yxp.eguodu.entity.ClassesStudent;
import com.yxp.eguodu.entity.ClassesTeacher;
import com.yxp.eguodu.entity.Student;
import com.yxp.eguodu.service.basemsg.ClassesService;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClassesServiceImp implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private StudentMapper studentMapper;



    @Override
    public List<Map<String, Object>> classesList(ClassesQueryParams params) {
        return classesMapper.classesList(params);
    }

    @Override
    public List<Map<String, Object>> classesListTotal(ClassesQueryParams params) {
        return classesMapper.classesListTotal(params);
    }

    @Override
    public int insertClasses(Classes classes) {
        return classesMapper.insertClasses(classes);
    }

    @Override
    public int updateClasses(Classes classes) {
        return classesMapper.updateClasses(classes);
    }

    @Override
    public int deleteClasses(Map<String,Object> paras) {
        return classesMapper.deleteClasses(paras);
    }

    @Override
    public List<Map<String, Object>> classesTeacherList(Map<String, Object> paras) {
        return classesMapper.classesTeacherList(paras);
    }

    @Override
    public int saveClassesTeacher(List<ClassesTeacher> classesTeachers) {
        List<Map<String,Object>> sourceTeachers = classesMapper.classesTeacherList(new HashedMap<String,Object>(){{
            put("schoolStyle",classesTeachers.get(0).getSchoolStyle());
            put("classesId" ,classesTeachers.get(0).getClassesId());
        }});

        sourceTeachers.stream().filter(o->o.get("teacherId").toString().equals("")).forEach(
                v -> {
                    classesTeachers.stream().filter(s->s.getStudySubjectId().equals(v.get("studySubjectId").toString())).forEach(
                            clt -> {
                                classesMapper.insertClassesTeacher(clt);
                            }
                    );
                }
        );

        sourceTeachers.stream().filter(o-> !o.get("teacherId").toString().equals("")).forEach(
                v ->{
                     ClassesTeacher ctl=  classesTeachers.stream().filter(s ->  s.getStudySubjectId().equals(v.get("studySubjectId").toString())).findFirst().orElse(null);
                     if(!ctl.getTeacherId().equals(v.get("teacherId").toString()))
                     {
                         classesMapper.classesTeacherLeave(new HashMap<String,Object>(){{
                               put("classesId", v.get("classesId").toString());
                               put("teacherId",v.get("teacherId").toString());
                               put("studySubjectId",v.get("studySubjectId").toString());
                         }});
                         classesMapper.insertClassesTeacher(ctl);
                     }



                }
        );



        return 0;
    }

    @Override
    public int groupAddStuents(Map<String, Object> paras) {
      String classesId=  paras.get("classesId").toString();
      List<Student> slist =  (List<Student>) paras.get("studentList")  ;
      List<ClassesStudent> ctulist = new ArrayList<ClassesStudent>();
      for (Student st : slist){
          ctulist.add(new ClassesStudent(classesId,st.getStudentId(),null,null));
      }
      classesMapper.groupInsertClassesStudents(ctulist);

       for (Student st : slist){
               Student OldStudent =studentMapper.findStudentById(new HashMap<String ,Object>(){{
                      put("studentId",st.getStudentId());
               }}).stream().findFirst().orElse(null);
               if (OldStudent != null){
                   st.setHeadimg(OldStudent.getHeadimg());
                   st.setNickname(OldStudent.getNickname());
                   st.setWxcode(OldStudent.getWxcode());
               }
               studentMapper.studentLeaveSchool(st);
               studentMapper.insertStudent(st);
        }


      return 0;
    }

    @Override
    public int insertClassesStudent(Map<String, Object> paras) {
        return 0;
    }

    @Override
    public int updateClassesStudent(ClassesStudent classesStudent) {
        return 0;
    }

    @Override
    public int classesStudentLeave(ClassesStudent classesStudent) {
        return 0;
    }
}
