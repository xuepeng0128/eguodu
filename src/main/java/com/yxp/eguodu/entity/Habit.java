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
    private String  habitId; // 习惯编号
    private int  grade; // 学籍
    private int  classes; // 班级
    private String  circleId; // 圈子id
    private String  circleTitle; // 圈子标题
    private String  habitClassId; // 类别id
    private String  habitClassName; // 类别名称
    private String  subHabitClassId; //  小类id
    private String  subHabitClassName; // 小类名称
    private String   icon; // icon
    private String  color; // 颜色
    private String  habitName; // 习惯名称
    private String  memo; // 描述
    private String  picUrl; // 海报
    private int  pirTime; //每 perTime （天，周,月）执行一次
    private String  timeUnit;// 天，周，月
    private int  mode;// 执行方式(1,时间模式，2.次数模式，3.数量模式   (次数模式暂不使用)
    private String  timeModeNum;//时间模式时间限制 默认（'00:30:00'） 30分钟
    private String  timeCompare ;// ‘lt’ 小于, 'gt'大于
    private Integer  countModeNum;// 次数模式次数
    private Float valueModeNum;// 数量模式 数量
    private String unitName;// 数量模式单位
    private Integer  guoduCoin; //  完成任务可获果度币
    private Float  score; // 考核习惯可获分数
    private String habitExamId; // 考核id
    private String examTitle ; // 考核标题
    private String totalScore; // 总分
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buildTime;// 建立时间
    private String  buildTeacherId; // 建习惯老师id
    private String  buildStudentId; // 建习惯学生id
    private Date putCardBeginDate; //   开始打卡日期
    private Date putCardEndDate; // 结束打卡日期
    private int joinStudents; // 习惯加入的学生数

}
