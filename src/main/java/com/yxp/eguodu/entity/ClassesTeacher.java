package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassesTeacher {
  private int  id;
  private String classesId;
  private String  teacherId;
  private String  teacherName;
  private String    studySubjectId;
  private String studySubjectName;
  private int schoolStyle;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date regTime;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date endTime;
}
