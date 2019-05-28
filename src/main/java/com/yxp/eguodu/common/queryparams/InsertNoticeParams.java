package com.yxp.eguodu.common.queryparams;

import com.yxp.eguodu.entity.Notice;
import com.yxp.eguodu.entity.NoticeStudent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertNoticeParams {
    private Notice notice;
    private List<NoticeStudent> noticeStudents;
}
