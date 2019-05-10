package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolExamExcelTemplate {
    private String studentId;
    private String studentName;
    private String subjectExamClassId;
    private String subjectExamClassName;
    private float fullScore;
    private float score;
}
