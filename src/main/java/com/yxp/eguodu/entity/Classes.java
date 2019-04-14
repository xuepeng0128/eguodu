package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//班级


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classes {

    private int grade;  // 年纪 学籍 2013 级
    private int classes;// 班级
    private Teacher headmaster; // 班主任
    private School school; // 所属学校
    private List<Teacher> assTeachers ; // 代课老师
    private List<Student> students; // 班级学生
}
