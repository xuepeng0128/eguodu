package com.yxp.eguodu.entity;

import lombok.Data;

@Data
public class SubExam {
   private int  id;
   private String         examId ; // 考试编号
   private String  studentId; //学号
   private String studentName; // 名称
   private String  subjectExamClassId ; // 题型编号
   private String  subjectExamClassName;  // 题型名称
   private int  defficulty; // 难易度 1.容易，2.普通，3.困难
   private float         score;  // 得分
   private float  getScore; // 满分

}
