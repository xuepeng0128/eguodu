package com.yxp.eguodu.wxcontroller.business;

import com.yxp.eguodu.service.business.TeacherLessonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value="微信习惯主题(课程)",tags={"微信小程序圈子主题(课程)相关操作webapi接口"})
@CrossOrigin
@RestController
@RequestMapping(value = "/api/wxlesson",  produces = "application/json;charset=UTF-8")
public class WxTeacherLessonCtrl {
   @Autowired
    private TeacherLessonService svr;

    @ApiOperation( value = " 根据圈子id 获取主题列表",notes = " " +
            " 返回字段：{" +
            "    data :[{" +
            "      lessonId :  课程id," +
            "      lessonTitle : 课程标题," +
            "        memo : 课程简介, " +
            "      guoduCoin : 学习课程花费果度币," +
            "     makeTeacherId : 建课老师id, " +
            "         makeTeacherName : 建课老师 ," +
            "              picUrl : 宣传画," +
            "       publishTime : 课程发布时间 " +
            "     }]" +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "circleId", value = "圈子id", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/teacherLessonByCircleId")
   public Map<String,Object> teacherLessonByCircleId(String circleId,String pageSize,String pageNo){
        String pageBegin= String.valueOf ((Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize));
        List<Map<String,Object>> list =svr.teacherLessonByCircleId(circleId, pageSize,pageBegin);
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        map.put("resultCode", "0");
        return map;
    }

//    @ApiOperation( value = " 根据课程id 获取课时",notes = " " +
//            " 返回字段：{" +
//            "    data : sub" +
//            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
//            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
//            "}")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "circleId", value = "圈子id", required = true, dataType = "String", paramType = "query"),
//    }
//    )
//    @GetMapping(value="/teacherLessonByCircleId")
//    public Map<String,Object> subLessonById(String lessonId){
//        String pageBegin= String.valueOf ((Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize));
//        List<Map<String,Object>> list =svr.teacherLessonByCircleId(circleId, pageSize,pageBegin);
//        Map map = new HashMap();
//        map.put("data", list );
//        map.put("resultMsg", "ok");
//        map.put("resultCode", "0");
//        return map;
//    }


}
