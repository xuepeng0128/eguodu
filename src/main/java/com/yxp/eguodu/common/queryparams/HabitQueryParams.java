package com.yxp.eguodu.common.queryparams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitQueryParams {
    private String  habitId;
    private String classesId;
    private String circleId;
    private String circleTitle;
    private String habitName;
    private String habitClassId;
    private String subHabitClassId;
    private String schoolId;
    private String buildTeacherId;
    private String buildStudentId;
    private String examed;
    private String allHabitStudentId; // 查询本学生参与的所有习惯
    private String todayStudentId; // 今日要打卡的学生id
    private String pageSize;
    private String pageNo;
    private String pageBegin;
}
