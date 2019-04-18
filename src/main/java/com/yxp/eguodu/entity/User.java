package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
     private String  userId;
     private String  account;
     private String  passWord;
     private String  schoolId;
     private String  employeeId;
     private String   teacherPaperId;
     private int supperAdmin;
     private int schoolAdmin;
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date addTime;
     private int  kind;

}
