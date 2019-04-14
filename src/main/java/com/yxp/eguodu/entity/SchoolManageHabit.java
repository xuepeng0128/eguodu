package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolManageHabit {

    private Teacher teacher; // 创建习惯的任职老师
    private Habit habit;  // 创建的习惯
    private Date buildDate; // 创建时间
    private int guodoubi; // 打卡所得果豆币
    private Date beginDate; // 习惯开始时间
    private Date endDate; // 习惯结束时间
    private List<Circle> circles; // 针对的圈子
}
