package com.yxp.eguodu.common.queryparams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamQueryParams {
    private String  classesIds ;
   private String  schoolId ;
   private String  pageBegin ;
   private String  pageSize ;
   private String  pageNo ;

}
