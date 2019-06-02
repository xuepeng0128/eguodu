package com.yxp.eguodu.common.queryparams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CircleQueryParams {
    private String circleTitle; // 圈子标题
    private String circleClassId; //  建圈类别编号
    private String schoolId;    // 学校编号
    private String schoolName; // 学校名称
    private String classesId; // 班级编号
    private String grade;     // 学籍
    private String classes;   // 班级
    private String classesName; // 班级名称
    private String buildTeacherId; // 建圈老师id
    private String buildTeacherName; // 建圈老师名称
    private String buildStudentId ; // 建圈学生id
    private String buildStudentName; //建圈学生名称
    private String buildTimeBegin ;// 建圈日期起
    private String  buildTimeEnd ;// 建圈日期起
    private String  closeMan; // 关闭人
    private String    closeTime ; // 关闭时间
    private String  closeReason ; // 关闭原因
    private String pageSize;
    private String pageNo;
    private String pageBegin;
}
