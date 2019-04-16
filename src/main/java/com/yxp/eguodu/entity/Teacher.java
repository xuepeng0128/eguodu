package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Teacher {
    private int id;
    private String paperId; // 身份证
    private String tel; // 电话
    private String teacherName; // 老师姓名
    private String teacherDutyId; // 当前职务
    private String address;
    private String schoolId;
    private Date regTime;
}
