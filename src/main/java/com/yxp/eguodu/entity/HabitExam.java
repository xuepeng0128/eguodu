package com.yxp.eguodu.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitExam {
    private String  habitExamId;
    private String teacherId;
    private String teacherName;
    private Date publishedDate;
    private String examTitle;
    private String examMemo;
    private Date examBeginDate;
    private Date examEndDate;
    private int totalScore;

}
