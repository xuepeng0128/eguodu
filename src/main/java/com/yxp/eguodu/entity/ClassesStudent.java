package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassesStudent {
   private String classesId;
   private String          studentId;
   private Date regTime;
   private Date         endTime;
}
