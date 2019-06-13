package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
   private String  noticeId;
   private String  noticeContent;
   private String  teacherId;
   @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
   private Date sendTime;
   private int receiveStudentNums;
   private int haveReadStudentNums;
}
