package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

// 学校机构老师创建的习惯

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherHabit {

    private String circleId; // 所属圈子
    private Teacher teacher; // 创建习惯的任职老师
    private Date buildDate; // 创建时间
    private Habit habit;  // 创建的习惯
    private int guodoubi; // 打卡所得果豆币
    private Date beginDate; // 习惯开始时间
    private Date endDate; // 习惯结束时间
    private List<Student> joinStudents; // 参加的学生
    private float score; // 考核的分值(每天)

}
