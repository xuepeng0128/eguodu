package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
// 习惯类
public class Habit {
    private String  habitId;
    private String  circleId;
    private String  habitClassId;
    private String   subHabitClassId;
    private String   icon;
    private String  color;
    private String  habitName;
    private String  memo;
    private String  picUrl;
    private int  pirTime;
    private String  timeUnit;
    private int  mode;
    private String  timeModeNum;
    private int  countModeNum;
    private float valueModeNum;
    private String unitName;
    private int  guoduCoin;
    private float  score;
    private String putCardExamId;
    private Date buildTime;
    private String  buildTeacherId;
    private String  buildStudentId;


}
