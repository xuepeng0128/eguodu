package com.yxp.eguodu.controller.basemsg;

import com.yxp.eguodu.common.queryparams.ClassesQueryParams;
import com.yxp.eguodu.entity.Classes;
import com.yxp.eguodu.entity.ClassesStudent;
import com.yxp.eguodu.entity.ClassesTeacher;
import com.yxp.eguodu.service.basemsg.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/basemsg/classes", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class ClassesCtrl {

    @Autowired
    private ClassesService svr;

    @GetMapping(value="/classesList")
    public List<Map<String,Object>> classesList (String classesId,String grade, String classes , String schoolId, String schoolName, String pageSize, String pageNo, String pageBegin)
    {
        ClassesQueryParams queryParams = new ClassesQueryParams( classesId, grade, classes ,  schoolId,  schoolName,  pageSize,  pageNo,  pageBegin);
        return svr.classesList(queryParams);
    }

    @GetMapping(value="/classesListTotal")
    public Map<String,Object> classesListTotal (String classesId, String grade, String classes , String schoolId, String schoolName, String pageSize, String pageNo, String pageBegin)
    {
        ClassesQueryParams queryParams = new ClassesQueryParams(classesId,  grade, classes ,  schoolId,  schoolName,  pageSize,  pageNo,  pageBegin);
        return
                new HashMap<String,Object>(){{
                    put("total", svr.classesListTotal(queryParams));

                }};
    }

    /**
     * 插入班级
     * @param classes
     * @return
     */
    @PostMapping(value="/insertClasses")
    public Map<String,Object> insertClasses(@RequestBody Classes classes){
       int d= svr.insertClasses(classes);
        if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }
    /**
     * 修改班级
     * @param classes
     * @return
     */
    @PostMapping(value="/updateClasses")
    public Map<String,Object> updateClasses(@RequestBody Classes classes){
        int d= svr.updateClasses(classes);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    /**
     * 删除班级
     * @param classesId
     * @return
     */
    @GetMapping(value="/deleteClasses")
    public Map<String,Object> deleteClasses(String classesId){
        int d= svr.deleteClasses(new HashMap<String,Object>(){{put("classesId",classesId) ;}});
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }


    @GetMapping(value="/classesTeacherList")
    public List<Map<String,Object>> classesTeacherList(String classesId,String schoolStyle){
          return svr.classesTeacherList(new HashMap<String,Object>(){{
              put("classesId",classesId);
              put("schoolStyle", Integer.parseInt(schoolStyle));
          }});
    }

    @PostMapping(value="/saveClassesTeacher")
    public Map<String,Object> saveClassesTeacher(@RequestBody ClassesTeacher classesTeacher){
           int d =svr.saveClassesTeacher(classesTeacher);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }


    @GetMapping(value="/teacherTeachedClasses")
    public List<Classes> teacherTeachedClasses(String teacherId,String schoolId){
           List<Classes> list = svr.teacherTeachedClasses(new HashMap<String,Object>(){{
               put("teacherId",teacherId);
               put("schoolId",schoolId);
           }});

           if(list != null && list.size()>0)
           {
               for (Classes c : list)
               {
                   c.setTeachers(   svr.subjectTeachersAtClasses(new HashMap<String,Object>(){{
                       put("classesId",c.getClassesId());
                       put("schoolId",schoolId);
                   }}));


                 List<Map<String,Object>> slist=  svr.studentAtClasses(new HashMap<String,Object>(){{
                       put("classesId",c.getClassesId());
                       put("schoolId",schoolId);
                   }});
                   List<ClassesStudent> students = new ArrayList<ClassesStudent>();
                   for (Map<String,Object> s : slist)
                   {
                       ClassesStudent cs = new ClassesStudent(c.getClassesId(),s.get("studentId").toString(),s.get("studentName").toString(),null,null);
                       students.add(cs);
                   }


                   c.setStudents( students);
               }
           }
           return list;
    }

    @GetMapping(value="/subjectTeachersAtClasses")
    public List<ClassesTeacher> subjectTeachersAtClasses(String classesId,String schoolId,String schoolStyle){
        List<ClassesTeacher> list = svr.subjectTeachersAtClasses(new HashMap<String,Object>(){{
            put("classesId",classesId);
            put("schoolId",schoolId);
            put("schoolStyle",schoolStyle);
        }});
        return list;
    }

    @GetMapping(value="/studentAtClasses")
    public List<Map<String,Object>> studentAtClasses(String classesId,String schoolId){
             return  svr.studentAtClasses(new HashMap<String,Object>(){{
                 put("classesId",classesId);
                 put("schoolId",schoolId);
             }});
    }




}
