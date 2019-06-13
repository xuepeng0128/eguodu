package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudySubject {

    private String studySubjectId; // 学科id
    private String studySubjectName;// 学科名称
    private String  habitClassId; // 习惯类别id
    private String habitClassName; // 习惯类别名称
    private String subHabitClassId; // 习惯子类别id
    private String subHabitClassName; // 习惯子类别名称
    private boolean primarySchool; // 是否小学课程
    private boolean middleSchool; //是否中学课程
}
