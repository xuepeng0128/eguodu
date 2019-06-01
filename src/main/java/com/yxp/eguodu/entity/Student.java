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
//学生类
public class Student {
   private  int id;
   private String studentPaperId; // 身份证
   private String studentId; // 学籍号
   private String studentName; // 学生名称
   private int sex; // 性别
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private  Date birthday; //出生日期
   private String schoolId; // 学校编号
   private String schoolName; // 学校名称(备用)
   private String address ; // 家庭住址
   private String tel; // 联系电话
   private String headimg; // 头像 url
   private String nickname; // 昵称
   private Date regTime; // 入校时间
   private String relationShipId; // 亲属关系id
   private String  wxcode; // 小程序openid

}
