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
    private int  habitClass;
    private int bSchool;
}
