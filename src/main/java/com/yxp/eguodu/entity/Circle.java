package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 圈子
public class Circle {

  private String circleId; // 圈子编号
  private String circleName; // 圈子名称
  private String classesId; // 班级编号
  private String buildTeacherPaperId; // 建圈老师id
  private Date  buildTime ;// 建圈日期
  private String  memo; // 圈子介绍
  private String  closeMan; // 关闭人
  private Date    closeTime ; // 关闭时间
  private String  closeReason ; // 关闭原因

}
