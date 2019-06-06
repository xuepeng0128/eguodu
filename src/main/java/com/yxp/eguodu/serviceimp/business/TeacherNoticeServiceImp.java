package com.yxp.eguodu.serviceimp.business;

import com.yxp.eguodu.common.queryparams.TeacherNoticeParams;
import com.yxp.eguodu.dao.business.TeacherNoticeMapper;
import com.yxp.eguodu.entity.TeacherNotice;
import com.yxp.eguodu.service.business.TeacherNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherNoticeServiceImp implements TeacherNoticeService {
    @Autowired
    private TeacherNoticeMapper mapper;
    @Override
    public List<TeacherNotice> teacherNoticeList(TeacherNoticeParams teacherNoticeParams) {
        return mapper.teacherNoticeList(teacherNoticeParams);
    }

    @Override
    public List<Map<String, Object>> teacherNoticeListTotal(TeacherNoticeParams teacherNoticeParams) {
        return mapper.teacherNoticeListTotal(teacherNoticeParams);
    }

    @Override
    public int insertTeacherNotice(TeacherNotice teacherNotice) {
        return mapper.insertTeacherNotice(teacherNotice);
    }
}
