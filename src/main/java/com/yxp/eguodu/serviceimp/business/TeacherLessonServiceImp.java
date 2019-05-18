package com.yxp.eguodu.serviceimp.business;

import com.yxp.eguodu.dao.business.TeacherLessonMapper;
import com.yxp.eguodu.entity.SubTeacherLesson;
import com.yxp.eguodu.entity.TeacherLesson;
import com.yxp.eguodu.service.business.TeacherLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherLessonServiceImp implements TeacherLessonService {
    @Autowired
    private TeacherLessonMapper mapper ;
    @Override
    public List<TeacherLesson> teacherLessonList(Map<String, Object> paras) {
        return mapper.teacherLessonList(paras);
    }

    @Override
    public List<Map<String, Object>> teacherLessonListTotal(Map<String, Object> paras) {
        return mapper.teacherLessonListTotal(paras);
    }

    @Override
    public List<Map<String, Object>> getTeacherLessonByLessonId(String lessonId) {
        return mapper.getTeacherLessonByLessonId(lessonId);
    }

    @Override
    public List<Map<String, Object>> lessonHabitList(Map<String, Object> paras) {
        return mapper.lessonHabitList(paras);
    }

    @Override
    public List<SubTeacherLesson> subTeacherLessonList(Map<String, Object> paras) {
        return mapper.subTeacherLessonList(paras);
    }

    @Override
    public int insertTeacherLesson(TeacherLesson teacherLesson) {
        return mapper.insertTeacherLesson(teacherLesson);
    }

    @Override
    public int insertSubTeacherLesson(SubTeacherLesson subTeacherLesson) {
        return mapper.insertSubTeacherLesson(subTeacherLesson);
    }

    @Override
    public int updateTeacherLesson(TeacherLesson teacherLesson) {
        return mapper.updateTeacherLesson(teacherLesson);
    }

    @Override
    public int updateSubTeacherLesson(SubTeacherLesson subTeacherLesson) {
        return mapper.updateSubTeacherLesson(subTeacherLesson);
    }

    @Override
    public int deleteTeacherLesson(Map<String, Object> paras) {
        return mapper.deleteTeacherLesson(paras);
    }

    @Override
    public int deleteSubTeacherLesson(String lessonId,int lessonNo) {
        return mapper.deleteSubTeacherLesson(lessonId,lessonNo);
    }
}
