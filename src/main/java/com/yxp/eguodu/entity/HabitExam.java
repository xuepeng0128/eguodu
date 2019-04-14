package com.yxp.eguodu.entity;



import java.util.Date;
import java.util.List;

public class HabitExam {

    private String examBatch; // 考核批次
    private String examMemo ; // 考核说明
    private Date beginExamDate; // 考核开始日期
    private Date endExamDate; // 考核结束日期
    private Teacher examTeacher; // 设定考核的老师
    private int totalScore; // 考核总分
    private List<TeacherHabit> teacherHabits;
}
