package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassesTeacher {
  private int  id;
  private String classesId;
  private String  teacherPaperId;
  private String  teacherName;
  private int    studySubjectId;
  private String studySubjectName;
  private Date regTime;
  private Date endTime;
}