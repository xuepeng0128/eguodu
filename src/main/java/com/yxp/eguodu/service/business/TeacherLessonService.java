package com.yxp.eguodu.service.business;

import com.yxp.eguodu.entity.SubTeacherLesson;
import com.yxp.eguodu.entity.TeacherLesson;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface TeacherLessonService {
    public List<TeacherLesson> teacherLessonList(Map<String,Object> paras);


    public List<Map<String,Object>> teacherLessonListTotal(Map<String,Object> paras);

    public List<Map<String,Object>> getTeacherLessonByLessonId(String lessonId);
    public List<Map<String,Object>> lessonHabitList(Map<String,Object> paras);

    public List<SubTeacherLesson> subTeacherLessonList(Map<String,Object> paras);

    public int insertTeacherLesson(TeacherLesson teacherLesson);

    public int insertSubTeacherLesson(SubTeacherLesson subTeacherLesson);
    public int updateTeacherLesson(TeacherLesson teacherLesson);
    public int updateSubTeacherLesson(SubTeacherLesson subTeacherLesson);

    public int deleteTeacherLesson(Map<String,Object> paras);
    public int deleteSubTeacherLesson(String lessonId,int lessonNo);
}
