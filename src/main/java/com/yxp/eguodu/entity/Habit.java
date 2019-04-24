package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
// 标准习惯模板
public class Habit {
  private String habitId;
  private String habitName;
  private String habitClassId ;
  private String habitClassName;
  private String subHabitClassId;
  private String subHabitClassName;
  private String memo ; // 文本描述
//  private String videoUrl ; // 视频
//  private String audioUrl ; // 音频
   private String picUrl; // 图片
}
