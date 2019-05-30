package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassesStudent {
   private String classesId;
   private String  studentId;
   private String studentName;
   private String studentPaperId;
   private int sex ;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date birthday;
   private String schoolId;
   private String address;
   private String tel;
   private String headimg;
   private String nickname;
   private String wxcode;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date regTime;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date endTime;
   private String inviteCode;
}
