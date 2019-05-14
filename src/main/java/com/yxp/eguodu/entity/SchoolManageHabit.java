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
public class SchoolManageHabit {

    private Teacher teacher; // 创建习惯的任职老师
    private Habit habit;  // 创建的习惯
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date buildDate; // 创建时间
    private int guodoubi; // 打卡所得果豆币
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate; // 习惯开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate; // 习惯结束时间
    private List<Circle> circles; // 针对的圈子
}
