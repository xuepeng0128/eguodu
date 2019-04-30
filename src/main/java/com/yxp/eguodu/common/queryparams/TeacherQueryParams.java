package com.yxp.eguodu.common.queryparams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherQueryParams {
    private String teacherId;
   private String teacherPaperId;
   private String teacherName;
   private String schoolId ;
   private String schoolName;
   private String teacherDutyId;
    private String pageSize;
    private String pageNo;
    private String pageBegin;
}
