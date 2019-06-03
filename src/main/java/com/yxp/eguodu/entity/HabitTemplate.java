package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitTemplate {
    private String  habitTemplateId;
    private String  habitTemplateName;
    private String  habitClassId;
    private String  habitClassName;
    private String  subHabitClassId;
    private String  subHabitClassName;
    private String  icon;
    private String  color;
    private String  memo; // 文本描述
    private String  picUrl;
    private int  perTime;
    private String timeUnit;
    private int  mode;
    private String  timeModeNum;
    private String  timeCompare ;
    private int  countModeNum;
    private float valueModeNum;
    private String  unitName;
}
