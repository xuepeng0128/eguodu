package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysInformation {
    private  int id;
    private  String information;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date sendTime;
}
