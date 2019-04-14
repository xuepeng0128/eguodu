package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Teacher {

    private String paperId; // 身份证
    private String tel; // 电话
    private String teacherName; // 老师姓名
    private TeacherDuty teacherDuty; // 当前职务
    private TeacherOnserve onserve; // 当前任教
}
