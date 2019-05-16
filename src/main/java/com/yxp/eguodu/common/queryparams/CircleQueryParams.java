package com.yxp.eguodu.common.queryparams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CircleQueryParams {

    private String circleTitle; // 圈子名称
    private String schoolId;
    private String schoolName;
    private String classesId; // 班级编号
    private String grade;
    private String classes;
    private String classesName;
    private String buildTeacherId; // 建圈老师id
    private String buildTeacherName;
    private String buildTimeBegin ;// 建圈日期起
    private String  buildTimeEnd ;// 建圈日期起
    private String  closeMan; // 关闭人
    private String    closeTime ; // 关闭时间
    private String  closeReason ; // 关闭原因
    private String pageSize;
    private String pageNo;
    private String pageBegin;
}
