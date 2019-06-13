package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParentHabit {

    private String circleIds; // 所属圈子
    private Student student; // 创建习惯的学生
    private Habit habit;  // 创建的习惯
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate; // 习惯开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate; // 习惯结束时间
    private Student joinStudent; // 参加的学生

}
