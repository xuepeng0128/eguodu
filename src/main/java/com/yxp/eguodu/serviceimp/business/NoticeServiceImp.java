package com.yxp.eguodu.serviceimp.business;

import com.yxp.eguodu.common.queryparams.InsertNoticeParams;
import com.yxp.eguodu.dao.business.NoticeMapper;
import com.yxp.eguodu.entity.Notice;
import com.yxp.eguodu.entity.NoticeStudent;
import com.yxp.eguodu.service.business.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImp  implements NoticeService {
    @Autowired
    private NoticeMapper mapper;
    @Override
    public List<Notice> noticeList(Map<String, Object> paras) {
        return mapper.noticeList(paras);
    }

    @Override
    public List<Map<String, Object>> noticeListTotal(Map<String, Object> paras) {
        return mapper.noticeListTotal(paras);
    }

    @Override
    public List<NoticeStudent> noticeStudentList(Map<String, Object> paras) {
        return mapper.noticeStudentList(paras);
    }

    @Override
    public int insertNotice(InsertNoticeParams params) {
        mapper.insertNotice(params.getNotice());
        mapper.insertNoticeStudent(params.getNoticeStudents());
        return 1;
    }

    @Override
    public int noticeStudentReceived(Map<String, Object> params) {
        return mapper.noticeStudentReceived(params);
    }
}
