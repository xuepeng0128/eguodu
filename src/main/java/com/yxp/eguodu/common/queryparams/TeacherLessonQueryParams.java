package com.yxp.eguodu.common.queryparams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherLessonQueryParams {
    private String lessonTitle;
    private String  teacherId;
    private String teacherName ;
    private String schoolId ;
    private String  schoolName ;
    private String  pageNo ;
    private String pageBegin ;
    private String pageSize ;
}
