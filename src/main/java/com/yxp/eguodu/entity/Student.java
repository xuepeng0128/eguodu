package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
   private  int id;
   private String studentPaperId;
   private String studentId;
   private String studentName;
   private int sex;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private  Date birthday;
   private String schoolId;
   private String schoolName;
   private String address ; // 家庭住址
   private String tel;
   private String headimg;
   private String nickname;
   private Date regTime;
   private String  wxcode; // 小程序openid

}
