package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

//班级


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classes {
    private String classesId;
    private int grade;  // 年纪 学籍 2013 级
    private int classes;// 班级
    private String classesName;
    private String  headMaster; // 班主任
    private String headMasterName;
    private String    schoolId; // 所属学校
    private String    schoolName; // 所属学校
    private Date regTime;
    private Date endTime;
    private List<ClassesTeacher> teachers;
    private List<ClassesStudent> students;

}
