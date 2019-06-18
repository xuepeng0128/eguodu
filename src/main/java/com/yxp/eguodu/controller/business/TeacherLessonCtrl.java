package com.yxp.eguodu.controller.business;

import com.yxp.eguodu.common.queryparams.InsertTeacherLessonParams;
import com.yxp.eguodu.common.queryparams.TeacherLessonQueryParams;
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
    public List<TeacherLesson> teacherLessonList(String lessonTitle,String schoolId,String schoolName, String teacherId,String teacherName,String pageNo, String pageBegin, String pageSize){
        TeacherLessonQueryParams teacherLessonQueryParams = new TeacherLessonQueryParams(lessonTitle,teacherId  , teacherName,schoolId,schoolName,  pageNo,  pageBegin,  pageSize);
        List<TeacherLesson> list = svr.teacherLessonList(teacherLessonQueryParams);
        return list;
    }


    @GetMapping(value="/teacherLessonListTotal")
    public Map<String,Object> teacherLessonListTotal(String lessonTitle,String schoolId,String schoolName, String teacherId,String teacherName,String pageNo, String pageBegin, String pageSize){
        TeacherLessonQueryParams teacherLessonQueryParams = new TeacherLessonQueryParams(lessonTitle,teacherId  , teacherName,schoolId,schoolName,  pageNo,  pageBegin,  pageSize);

        List<Map<String,Object>> list = svr.teacherLessonListTotal(teacherLessonQueryParams);
        Map<String,Object> re= new HashMap<String,Object>();
        re.put("total",Integer.parseInt( list.get(0).get("total").toString()));
        return re;
    }

    @GetMapping(value="/subTeacherLessonList")
    public List<SubTeacherLesson> subTeacherLessonList(String lessonId){
        List<SubTeacherLesson> slist =svr.subTeacherLessonList(lessonId,"0","1000");
        return slist;
    }
    @PostMapping(value="/saveTeacherLesson")
    public Map<String,Object> saveTeacherLesson(@RequestBody InsertTeacherLessonParams lesson){
        TeacherLesson teacherLesson= lesson.getTeacherLesson();
        List<SubTeacherLesson> subTeacherLessons =lesson.getSubTeacherLessons();
        if(svr.getTeacherLessonByLessonId(teacherLesson.getLessonId()).size()>0){
            svr.updateTeacherLesson(teacherLesson);
        }else {
            svr.insertTeacherLesson(teacherLesson);
        }
        svr.deleteSubTeacherLesson(teacherLesson.getLessonId());
        for(SubTeacherLesson s : subTeacherLessons){
            svr.insertSubTeacherLesson(s);
        }
        return new HashMap<String,Object>(){{put("result","ok") ;}} ;
    }


    @GetMapping(value="/publishToHabit")
    public  Map<String,Object> publishToHabit(String habitId, String lessonId){

         svr.publishToHabit(habitId,lessonId);

        return new HashMap<String,Object>(){{put("result","ok") ;}} ;
    }

}
