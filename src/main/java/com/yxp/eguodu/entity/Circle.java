package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 圈子
public class Circle {

  private String circleId; // 圈子编号
  private String circleTitle; // 圈子标题
  private String subTitle ; // 副标题
  private String circleClassId; // 类别
  private String circleClassName; // 类别名称
  private String schoolId ; // 所属学校
  private String schoolName; // 所属学校名称
  private String classesId; // 班级编号
  private String grade; // 学籍
  private String classes ; // 班级
  private String classesName; // 班级名称
  private String buildTeacherId; // 建圈老师id
  private String buildTeacherName;
  private String buildStudentId; // 建圈学生id
  private String buildStudentName; // 建圈学生名称
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date  buildTime ;// 建圈日期
  private String  memo; // 圈子介绍
  private String picUrl; // 宣传海报
  private String  closeMan; // 关闭人
  @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
  private Date    closeTime ; // 关闭时间
  private String  closeReason ; // 关闭原因
  private int   circleProperty; // 圈子性质 1.私有 2.公开

}
