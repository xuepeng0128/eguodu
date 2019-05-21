package com.yxp.eguodu.common.queryparams;

import com.yxp.eguodu.entity.SubTeacherLesson;
import com.yxp.eguodu.entity.TeacherLesson;
import lombok.Data;

import java.util.List;

@Data
public class InsertTeacherLessonParams {
   private TeacherLesson teacherLesson ;
   private  List<SubTeacherLesson> subTeacherLessons;
}
