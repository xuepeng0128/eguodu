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

   private String paperId;
   private String studentName;
   private Date birthday;
   private String sex;
   private String address ; // 家庭住址
   private String tel;
   private List<String> openIds; // 小程序openid

}
