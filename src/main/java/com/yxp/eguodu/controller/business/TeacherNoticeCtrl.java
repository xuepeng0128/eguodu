package com.yxp.eguodu.controller.business;

import com.yxp.eguodu.common.queryparams.InsertNoticeParams;
import com.yxp.eguodu.common.queryparams.TeacherNoticeParams;
import com.yxp.eguodu.entity.Notice;
import com.yxp.eguodu.entity.NoticeStudent;
import com.yxp.eguodu.entity.TeacherNotice;
import com.yxp.eguodu.service.business.TeacherNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/business/teachernotice", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class TeacherNoticeCtrl {
   @Autowired
   private TeacherNoticeService svr;

    @GetMapping(value="/teachernoticeList")
    public List<TeacherNotice> teachernoticeList(String buildTeacherId, String schoolId ,   String pageSize, String pageNo, String pageBegin)
    {
        TeacherNoticeParams teacherNoticeParams = new TeacherNoticeParams(null, null, null,
                                                                                    null,null,buildTeacherId,null,
                                                                                         schoolId, pageNo, pageBegin ,pageSize );
        return svr.teacherNoticeList(teacherNoticeParams);
    }


    @GetMapping(value="/teacherNoticeListTotal")
    public Map<String,Object> teacherNoticeListTotal(String teacherId, String schoolId ,   String pageSize, String pageNo, String pageBegin)
    {
        TeacherNoticeParams teacherNoticeParams = new TeacherNoticeParams(null, null, null,
                null,null,teacherId,null,
                schoolId, pageNo, pageBegin ,pageSize );
        List<Map<String,Object>> list = svr.teacherNoticeListTotal( teacherNoticeParams);
        Map<String,Object> re= new HashMap<String,Object>();
        re.put("total",Integer.parseInt( list.get(0).get("total").toString()));
        return re;
    }


    @PostMapping(value="/insertTeacherNotice")
    public Map<String,Object> insertNotice(@RequestBody TeacherNotice teacherNotice){
        svr.insertTeacherNotice(teacherNotice);
        return new HashMap<String,Object>(){{put("result","ok") ;}} ;
    }

}
