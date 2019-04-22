package com.yxp.eguodu.common.queryparams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassesQueryParams {
    private String classesId;
   private String grade;
   private String classes ;
   private String schoolId;
   private String schoolName;
    private String pageSize;
    private String pageNo;
    private String pageBegin;


}
