package com.yxp.eguodu.service.business;

import com.yxp.eguodu.common.queryparams.TeacherNoticeParams;
import com.yxp.eguodu.entity.TeacherNotice;

import java.util.List;
import java.util.Map;

public interface TeacherNoticeService {

    public List<TeacherNotice> teacherNoticeList(TeacherNoticeParams teacherNoticeParams);



    public List<Map<String,Object>> teacherNoticeListTotal(TeacherNoticeParams teacherNoticeParams);


    public int insertTeacherNotice(TeacherNotice teacherNotice);

}
