package com.yxp.eguodu.service.business;

import com.yxp.eguodu.common.queryparams.TeacherLessonQueryParams;
import com.yxp.eguodu.entity.SubTeacherLesson;
import com.yxp.eguodu.entity.TeacherLesson;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface TeacherLessonService {
    public List<TeacherLesson> teacherLessonList(TeacherLessonQueryParams queryParams);


    public List<Map<String,Object>> teacherLessonListTotal(TeacherLessonQueryParams queryParams);

    public List<Map<String,Object>> getTeacherLessonByLessonId(String lessonId);
    public List<Map<String,Object>> lessonHabitList(Map<String,Object> paras);

    public List<SubTeacherLesson> subTeacherLessonList(String lessonId);

    public int insertTeacherLesson(TeacherLesson teacherLesson);

    public int insertSubTeacherLesson(SubTeacherLesson subTeacherLesson);
    public int updateTeacherLesson(TeacherLesson teacherLesson);
    public int updateSubTeacherLesson(SubTeacherLesson subTeacherLesson);

    public int deleteTeacherLesson(Map<String,Object> paras);
    public int deleteSubTeacherLesson(String lessonId,int lessonNo);
    public int publishToHabit( String lessonId,  String habitId);
}
