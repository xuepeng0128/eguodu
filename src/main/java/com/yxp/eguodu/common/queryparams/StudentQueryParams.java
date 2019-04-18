package com.yxp.eguodu.common.queryparams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentQueryParams {
    private String studentId;
    private String paperId;
    private String studentName;
    private String schoolId ;
    private String schoolName;
    private String pageSize;
    private String pageNo;
    private String pageBegin;
}
