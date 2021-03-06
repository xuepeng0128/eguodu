package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String paperId;
    private String employeeName;
    private String tel;
    private String corpDutyId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   enterDate;
    private Integer  onDutyState;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  leaveDate;
}
