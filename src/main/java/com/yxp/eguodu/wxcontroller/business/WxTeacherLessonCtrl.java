package com.yxp.eguodu.wxcontroller.business;

import com.yxp.eguodu.entity.SubTeacherLesson;
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
            "       haveBuy : 本人是否已购买 （0，否，1.是)" +
            "     }]" +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "circleId", value = "圈子id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "studentId", value = "学生id", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/teacherLessonByCircleId")
   public Map<String,Object> teacherLessonByCircleId(String circleId,String studentId,String pageSize,String pageNo){
        String pageBegin= String.valueOf ((Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize));
        List<Map<String,Object>> list =svr.teacherLessonByCircleId(circleId,studentId, pageSize,pageBegin);
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        map.put("resultCode", "0");
        return map;
    }

    @ApiOperation( value = " 根据课程id 获取课时",notes = " " +
            " 返回字段：{" +
            "    data : SubTeacherLesson 数组" +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lessonId", value = "课程id", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/subLessonById")
    public Map<String,Object> subLessonById(String lessonId,String pageNo,String pageSize){
        String pageBegin= String.valueOf ((Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize));
        List<SubTeacherLesson> list =svr.subTeacherLessonList(lessonId,pageBegin, pageSize);
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        map.put("resultCode", "0");
        return map;
    }


    @ApiOperation( value = " 购买课程",notes = " " +
            " 返回字段：{" +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lessonId", value = "课程id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "studentId", value = "学生id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "guoduCoin", value = "花费果度币", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/studentBuyLesson")
    public Map<String,Object> studentBuyLesson( String lessonId, String studentId, String guoduCoin){

        int d = svr.studentBuyLesson(lessonId,studentId,guoduCoin);
        if (d>=0){
            return new HashMap<String,Object>(){{
                put("resultMsg","ok") ;
                put("resultCode","0");
            }} ;
        }
        else{
            return new HashMap<String,Object>(){{
                put("resultMsg","fail") ;
                put("resultCode","9");
            }} ;
        }
    }


}
