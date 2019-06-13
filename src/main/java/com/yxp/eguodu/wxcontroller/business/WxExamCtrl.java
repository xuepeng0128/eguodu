package com.yxp.eguodu.wxcontroller.business;

import ch.qos.logback.core.joran.util.StringToObjectConverter;
import com.yxp.eguodu.common.queryparams.ExamQueryParams;
import com.yxp.eguodu.entity.Exam;
import com.yxp.eguodu.service.business.ExamService;
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

@Api(value="微信考试",tags={"微信小程序考试相关操作webapi接口"})
@CrossOrigin
@RestController
@RequestMapping(value = "/api/wxexam",  produces = "application/json;charset=UTF-8")
public class WxExamCtrl {
    @Autowired
    private ExamService svr;


    //获取班级考试列表
    @ApiOperation( value = "学生班级考试列表 ",notes = " " +
            " 返回字段：{" +
            "    data :  Exam 对象数组 " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "classesIds", value = "班级id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "schoolId", value = "学校id", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/classesExamList")
    public Map<String,Object> examList(String  classesIds , String  schoolId ,
                               String  pageSize ,
                               String  pageNo ){
        String pageBegin= String.valueOf ((Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize));
        if(!classesIds.equals(""))
            classesIds = "'" +classesIds.replace(",","','") +"'";
        ExamQueryParams examQueryParams = new ExamQueryParams(classesIds,schoolId,pageBegin,pageSize,pageNo);
        List<Exam> list = svr.examList(examQueryParams);
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        return map;
    }




    // 班级分数统计
    @ApiOperation( value = "班级分数统计 ",notes = " " +
            " 返回字段：{" +
            "    data :  WxPutCardDiary 对象数组 " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentId", value = "圈子id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "examId", value = "考试id", required = false, dataType = "String", paramType = "query"),
          }
    )
    @GetMapping(value="/classesExamScoreCensus")

  public Map<String,Object> classesExamScoreCensus(String studentId,String examId){
      return null;
    }


}
