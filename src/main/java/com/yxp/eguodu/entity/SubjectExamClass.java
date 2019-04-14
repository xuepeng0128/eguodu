package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectExamClass {

    private String subjectExamClassId;
    private String subjectExamClassName;
    private String studySubjectId;
    private String studySubjectName;

}
