package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherLesson {
   private String  lessonId ;
   private String  lessonTitle;
   private String   memo;
   private int   guoduCoin;
   private String makeTeacherId;
   private String makeTeackerName;
   private Date makeTime;
   private String schoolId;

}
