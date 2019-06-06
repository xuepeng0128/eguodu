package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherNotice {
   private String  teacherNoticeId;
   private Date buildDate;
   private String  memo;
   private String  sendCircleIds;
   private String sendCircleTitles;
   private String  buildTeacherId;
   private String buildTeacherName;
   private String schoolId;
}
