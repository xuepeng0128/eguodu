package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudySubject {

    private int studySubjectId;
    private String studySubjectName;
    private String  habitClassId;
    private String habitClassName;
    private String subHabitClassId;
    private String subHabitClassName;
    private boolean primarySchool; // 是否小学课程
    private boolean middleSchool; //是否中学课程
}
