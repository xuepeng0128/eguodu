package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
// 习惯类
public class Habit {
    private String  habitId;
    private int  grade;
    private int  classes;
    private String  circleId;
    private String  circleTitle;
    private String  habitClassId;
    private String  habitClassName;
    private String  subHabitClassId;
    private String  subHabitClassName;
    private String   icon;
    private String  color;
    private String  habitName;
    private String  memo;
    private String  picUrl;
    private int  pirTime;
    private String  timeUnit;
    private int  mode;
    private String  timeModeNum;
    private String  timeCompare ;
    private Integer  countModeNum;
    private Float valueModeNum;
    private String unitName;
    private Integer  guoduCoin;
    private Float  score;
    private String habitExamId;
    private String examTitle ;
    private String totalScore;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buildTime;
    private String  buildTeacherId;
    private String  buildStudentId;
    private Date putCardBeginDate;
    private Date putCardEndDate;
    private int joinStudents;

}
