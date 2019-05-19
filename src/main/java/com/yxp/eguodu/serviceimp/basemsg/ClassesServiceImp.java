package com.yxp.eguodu.serviceimp.basemsg;

import com.yxp.eguodu.common.queryparams.ClassesQueryParams;
import com.yxp.eguodu.dao.basemsg.ClassesMapper;
import com.yxp.eguodu.dao.basemsg.StudentMapper;
import com.yxp.eguodu.entity.Classes;
import com.yxp.eguodu.entity.ClassesStudent;
import com.yxp.eguodu.entity.ClassesTeacher;
import com.yxp.eguodu.entity.Student;
import com.yxp.eguodu.service.basemsg.ClassesService;
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
    public int saveClassesTeacher(ClassesTeacher classesTeacher) {

     List<Map<String,Object>>  sourcelist=  classesMapper.findClassesTeacherBySubjectId(new HashMap<String,Object>(){{
            put("classesId",classesTeacher.getClassesId());
            put("studySubjectId",classesTeacher.getStudySubjectId());
        }});
        if (sourcelist != null && sourcelist.size()>0)
        {
            classesMapper.classesTeacherLeave(new HashMap<String,Object>(){{
                put("classesId",classesTeacher.getClassesId());
                put("teacherId",sourcelist.get(0).get("teacherId").toString());
                put("studySubjectId",classesTeacher.getStudySubjectId());
            }});
        }


         classesMapper.insertClassesTeacher(classesTeacher);

//        List<Map<String,Object>> sourceTeachers = classesMapper.classesTeacherList(new HashedMap<String,Object>(){{
//            put("schoolStyle",classesTeachers.get(0).getSchoolStyle());
//            put("classesId" ,classesTeachers.get(0).getClassesId());
//        }});
//
//        sourceTeachers.stream().filter(o->o.get("teacherId").toString().equals("")).forEach(
//                v -> {
//                    classesTeachers.stream().filter(s->s.getStudySubjectId().equals(v.get("studySubjectId").toString())).forEach(
//                            clt -> {
//                                classesMapper.insertClassesTeacher(clt);
//                            }
//                    );
//                }
//        );
//
//        sourceTeachers.stream().filter(o-> !o.get("teacherId").toString().equals("")).forEach(
//                v ->{
//                     ClassesTeacher ctl=  classesTeachers.stream().filter(s ->  s.getStudySubjectId().equals(v.get("studySubjectId").toString())).findFirst().orElse(null);
//                     if(!ctl.getTeacherId().equals(v.get("teacherId").toString()))
//                     {
//                         classesMapper.classesTeacherLeave(new HashMap<String,Object>(){{
//                               put("classesId", v.get("classesId").toString());
//                               put("teacherId",v.get("teacherId").toString());
//                               put("studySubjectId",v.get("studySubjectId").toString());
//                         }});
//                         classesMapper.insertClassesTeacher(ctl);
//                     }
//
//
//
//                }
//        );



        return 1;
    }




    @Override
    public int insertClassesStudent(ClassesStudent classesStudent) {
        classesMapper.insertClassesStudent(classesStudent);
        studentMapper.insertStudent(new Student( 0,classesStudent.getStudentPaperId(),classesStudent.getStudentId(),
                                                     classesStudent.getStudentName(),
                                                     classesStudent.getSex(), classesStudent.getBirthday(),classesStudent.getSchoolId(),
                                                      classesStudent.getAddress(), classesStudent.getTel(),
                                                     null,null,null,null)
        );
        return 1;
    }

    @Override
    public int updateClassesStudent(ClassesStudent classesStudent) {
        studentMapper.updateStudent(
                new Student( 0,classesStudent.getStudentPaperId(),classesStudent.getStudentId(),
                        classesStudent.getStudentName(),
                        classesStudent.getSex(), classesStudent.getBirthday(),classesStudent.getSchoolId(),
                        classesStudent.getAddress(), classesStudent.getTel(),
                        null,null,null,null)
        );
        return 1;
    }

    @Override
    public int classesStudentLeave(ClassesStudent classesStudent) {

        classesMapper.classesStudentLeave(new HashMap<String,Object>(){{
            put("classesId" , classesStudent.getClassesId());
            put("studentId" , classesStudent.getStudentId());
        }});
        studentMapper.studentLeaveSchool(
                new Student( 0,classesStudent.getStudentPaperId(),classesStudent.getStudentId(),
                        classesStudent.getStudentName(),
                        classesStudent.getSex(), classesStudent.getBirthday(),classesStudent.getSchoolId(),
                        classesStudent.getAddress(), classesStudent.getTel(),
                        null,null,null,null)
        );
        return 1;
    }

    @Override
    public int deleteClassesStudent(Map<String, Object> paras) {
        return classesMapper.deleteClassesStudent(paras);
    }


    @Override
    public int groupAddStudents(String classId, List<Student> studentList) {
      String classesId= classId;
      List<Student> slist =  studentList;
      List<ClassesStudent> ctulist = new ArrayList<ClassesStudent>();
      for (int i=0; i<slist.size();i++){

          ctulist.add(new ClassesStudent(classesId,slist.get(i).getStudentId(),slist.get(i).getStudentName(),slist.get(i).getStudentPaperId(),
                                    slist.get(i).getSex(),slist.get(i).getBirthday(),slist.get(i).getSchoolId(),slist.get(i).getAddress()
                                    ,slist.get(i).getTel(),null,null,null,null,null));
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
             //  studentMapper.studentLeaveSchool(st);
               studentMapper.insertStudent(st);
        }
        return 1;
    }



    @Override
    public List<Map<String, Object>> studentAtClasses(Map<String, Object> paras) {
        return classesMapper.studentAtClasses(paras);
    }

    @Override
    public List<Classes> teacherTeachedClasses(String teacherId,String schoolId) {
        return classesMapper.teacherTeachedClasses(teacherId,schoolId);
    }

    @Override
    public List<Classes> gradeClasses(Map<String, Object> paras) {
        return classesMapper.gradeClasses(paras);
    }

    @Override
    public List<ClassesTeacher> subjectTeachersAtClasses(Map<String, Object> paras) {
        return classesMapper.subjectTeachersAtClasses(paras);
    }
}
