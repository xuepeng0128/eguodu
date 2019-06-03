package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitTemplate {
    private String  habitTemplateId; // 习惯模板id
    private String  habitTemplateName; // 习惯名称
    private String  habitClassId; // 习惯类别id
    private String  habitClassName; //习惯类别名称
    private String  subHabitClassId; //  习惯小类id
    private String  subHabitClassName; // 习惯小类名称
    private String  icon; // icon url
    private String  color; // 背景色
    private String  memo; // 文本描述
    private String  picUrl; // 海报贴图
    private int  perTime;  //  每 perTime （天，周,月）执行一次
    private String timeUnit;// 天，周，月
    private int  mode; // 执行方式(1,时间模式，2.次数模式，3.数量模式   (次数模式暂不使用)
    private String  timeModeNum; //时间模式时间限制 默认（'00:30:00'） 30分钟
    private String  timeCompare ; // ‘lt’ 小于, 'gt'大于
    private int  countModeNum; // 次数模式次数
    private float valueModeNum; // 数量模式 数量
    private String  unitName; // 数量模式单位
}
