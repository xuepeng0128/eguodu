package com.yxp.eguodu.common.queryparams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolQueryParams {
       private String schoolId;
       private String schoolName;
       private String cityId;
       private String districtId;
       private String schoolStyle;
       @DateTimeFormat(pattern="yyyy-MM-dd")
       private        Date regTimeBegin;
       @DateTimeFormat(pattern="yyyy-MM-dd")
       private        Date regTimeEnd;
       private boolean train;
       private String  saleManId;
       private String pageSize;
       private String pageNo;
       private String pageBegin;

}
