package com.yxp.eguodu.common.queryparams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryParams {
    private String schoolId;
    private String account;
    private String employeeName;
    private String teacherName;
    private String schoolAdmin;
    private String kind;
    private String pageSize;
    private String pageNo;
    private String pageBegin;
}
