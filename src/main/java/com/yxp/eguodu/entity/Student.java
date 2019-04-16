package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
   private  int id;
   private String paperId;
   private String studentId;
   private String studentName;
    private String schoolId;
   private String address ; // 家庭住址
   private String tel;
   private Date regTime;
   private String  wxCode; // 小程序openid

}
