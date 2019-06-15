package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubExam {
   private int  id;
   private String         examId ; // 考试编号
   private String  studentId; //学号
   private String studentName; // 名称
   private String  subjectExamClassId ; // 题型编号
   private String  subjectExamClassName;  // 题型名称
   private String subjectExamNos; // 题号
   private int  defficulty; // 难易度 1.容易，2.普通，3.困难
   private float         score;  // 得分
   private float  getScore; // 满分
   private int subjects; // 题目数
   private int rightSubjects; // 答对题目数
   private int partSubjects; // 部分作对
}
