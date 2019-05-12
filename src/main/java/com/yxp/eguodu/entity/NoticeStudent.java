package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeStudent {
    private String  noticeId;
    private String  studentId;
    private String  studentName;
    private Date receiveTime;
}

