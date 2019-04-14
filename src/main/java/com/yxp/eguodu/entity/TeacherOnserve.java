package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 老师任教

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherOnserve {
    private School school; // 任教学校
    private Integer grade;  // 年纪
    private Integer classes;// 班级
    private TeacherDuty teacherDuty; // 职务
}
