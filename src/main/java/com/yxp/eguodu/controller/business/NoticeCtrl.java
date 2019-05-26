package com.yxp.eguodu.controller.business;

import com.yxp.eguodu.common.queryparams.InsertNoticeParams;
import com.yxp.eguodu.entity.Notice;
import com.yxp.eguodu.entity.NoticeStudent;
import com.yxp.eguodu.service.business.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/basemsg/notice", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class NoticeCtrl {
   @Autowired
    private NoticeService svr;

   @GetMapping(value="/noticeList")
   public List<Notice> noticeList(String teacherId,String noticeContent ,String pageBegin ,String pageSize)
   {
          Map<String,Object> paras = new HashMap<String,Object>(){{
              put("teacherId",teacherId);
              put("noticeContent",noticeContent);
              put("pageBegin",pageBegin);
              put("pageSize",pageSize);
          }};
          return svr.noticeList(paras);
   }


    @GetMapping(value="/noticeListTotal")
    public Map<String,Object> noticeListTotal(String teacherId,String noticeContent ,String pageBegin ,String pageSize)
    {
        Map<String,Object> paras = new HashMap<String,Object>(){{
            put("teacherId",teacherId);
            put("noticeContent",noticeContent);
            put("pageBegin",pageBegin);
            put("pageSize",pageSize);
        }};
        List<Map<String,Object>> list = svr.noticeListTotal( paras);
        Map<String,Object> re= new HashMap<String,Object>();
        re.put("total",Integer.parseInt( list.get(0).get("total").toString()));
        return re;
    }


    @GetMapping(value="/noticeStudentList")
    public List<NoticeStudent> noticeStudentList(String schoolId,String noticeId){
        Map<String,Object> paras = new HashMap<String,Object>(){{
            put("schoolId",schoolId);
            put("noticeId",noticeId);
        }};
        return svr.noticeStudentList(paras);
    }

    @PostMapping(value="/insertNotice")
    public Map<String,Object> insertNotice(@RequestBody InsertNoticeParams params){
          svr.insertNotice(params);
          return new HashMap<String,Object>(){{put("result","ok") ;}} ;
    }
}
