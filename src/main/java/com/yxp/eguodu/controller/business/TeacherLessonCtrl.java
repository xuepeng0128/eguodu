package com.yxp.eguodu.controller.business;

import com.yxp.eguodu.entity.SubTeacherLesson;
import com.yxp.eguodu.entity.TeacherLesson;
import com.yxp.eguodu.service.business.TeacherLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/business/teacherLesson", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class TeacherLessonCtrl {
    @Autowired
    private TeacherLessonService svr;


    @GetMapping(value="/teacherLessonList")
    public List<TeacherLesson> teacherLessonList(String schoolId, String teacherId, String pageBegin, String pageSize){
        List<TeacherLesson> list = svr.teacherLessonList(new HashMap<String,Object>(){{
            put("schoolId",schoolId);
            put("teacherId",teacherId);
            put("pageBegin",pageBegin);
            put("pageSize",pageSize);
        }});
        return list;
    }


    @GetMapping(value="/teacherLessonListTotal")
    public Map<String,Object> teacherLessonListTotal(String schoolId, String teacherId, String pageBegin, String pageSize){
        List<Map<String,Object>> list = svr.teacherLessonListTotal(new HashMap<String,Object>(){{
            put("schoolId",schoolId);
            put("teacherId",teacherId);
            put("pageBegin",pageBegin);
            put("pageSize",pageSize);
        }});
        Map<String,Object> re= new HashMap<String,Object>();
        re.put("total",Integer.parseInt( list.get(0).get("total").toString()));
        return re;
    }

    @PostMapping(value="/saveTeacherLesson")
    public Map<String,Object> saveTeacherLesson(@RequestBody Map<String,Object> lesson){
        TeacherLesson teacherLesson= (TeacherLesson) lesson.get("teacherLesson");
        List<SubTeacherLesson> subTeacherLessons =(List<SubTeacherLesson>) lesson.get("subTeacherLessons");
        if(svr.getTeacherLessonByLessonId(teacherLesson.getLessonId()).size()>0){
            svr.updateTeacherLesson(teacherLesson);
        }else {
            svr.insertTeacherLesson(teacherLesson);
        }
        for(SubTeacherLesson s : subTeacherLessons){
            svr.deleteSubTeacherLesson(s.getLessonId(),s.getLessonNo());
            svr.insertSubTeacherLesson(s);
        }
        return new HashMap<String,Object>(){{put("result","ok") ;}} ;
    }



}
