package com.yxp.eguodu.service.business;

import com.yxp.eguodu.entity.Notice;
import com.yxp.eguodu.entity.NoticeStudent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface NoticeService {

    public List<Notice> noticeList(Map<String,Object> paras);
    public List<Map<String,Object>> noticeListTotal(Map<String,Object> paras);
    public List<NoticeStudent> noticeStudentList(Map<String,Object> paras);
    public int insertNotice(Map<String,Object> paras);
    public int noticeStudentReceived(Map<String,Object> params);
}
