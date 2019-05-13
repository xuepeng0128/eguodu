package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
   private String  noticeId;
   private String  noticeContent;
   private String  teacherId;
   private Date sendTime;
   private int receiveStudentNums;
   private int haveReadStudentNums;
}
