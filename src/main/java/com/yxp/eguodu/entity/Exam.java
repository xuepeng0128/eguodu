package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam {
   private String  examId ; //考试编号
   private String  studySubjectId; // 学科编号
   private String  studySubjectName; // 学科名称
   private String  examName ;// 考试名称
   private String  teachedTeacherId; // 任教老师编号
   private String  teachedTeacherName; // 任教老师名称
   private Date examTime ; // 考试时间
   private String  examKindId ; // 考试类别编号
   private String  examKindName; //考试类别名称
   private int iyear ; // 年级
   private String  term; // 学期 up 上学期, down 下学期
   private String   classesId ; // 班级id
   private int   grade ; // 学籍
   private int   classes ; // 班级
   private String SchoolId ; // 学校id
   private int totalScore; //总分
    List<SubExam> subExams;
}
