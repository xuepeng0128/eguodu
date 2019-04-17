package com.yxp.eguodu.common.queryparams;

import java.util.Date;

public class CircleQueryParams {

    private String circleName; // 圈子名称
    private String schoolId;
    private String schoolName;
    private String classesId; // 班级编号
    private String grade;
    private String classes;
    private String buildTeacherPaperId; // 建圈老师id
    private String buildTeacherName;
    private String existTeacherName; // 班级圈所在的老师
    private String existStudentPaperId; // 圈子所在学生id
    private String existStudentName; //  圈子所在学生name
    private String habitName; // 圈内习惯
    private Date buildTimeBegin ;// 建圈日期起
    private Date buildTimeEnd ;// 建圈日期起

    private String  memo; // 圈子介绍
    private String  closeMan; // 关闭人
    private Date    closeTime ; // 关闭时间
    private String  closeReason ; // 关闭原因

}
