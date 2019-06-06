package com.yxp.eguodu.common.queryparams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherNoticeParams {
   private String  teacherNoticeId;
   private String  buildDateBegin;
    private String  buildDateEnd;
   private String  memo;
   private String sendCircleIds;
   private String  buildTeacherId;
   private String  buildTeacherName;
   private String schoolId;
    private String  pageNo ;
    private String pageBegin ;
    private String pageSize ;
}
