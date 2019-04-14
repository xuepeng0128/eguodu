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
  private String habitClass ; // (1,德2.智3.体4.美5.劳)
  private String memo ; // 文本描述
//  private String videoUrl ; // 视频
//  private String audioUrl ; // 音频
//  private String picUrl; // 图片
}
