package com.yxp.eguodu.wxcontroller.business;

import ch.qos.logback.core.joran.util.StringToObjectConverter;
import com.yxp.eguodu.common.queryparams.ExamQueryParams;
import com.yxp.eguodu.entity.Exam;
import com.yxp.eguodu.entity.SubExam;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(value="微信考试",tags={"微信小程序考试相关操作webapi接口"})
@CrossOrigin
@RestController
@RequestMapping(value = "/api/wxexam",  produces = "application/json;charset=UTF-8")
public class WxExamCtrl {
    @Autowired
    private ExamService svr;


    //获取班级考试列表
    @ApiOperation( value = "学生id获取考试列表 ",notes = " " +
            " 返回字段：{" +
            "    data :  [{" +
            "}] " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentId", value = "学生id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页数", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNo", value = "页码", required = true, dataType = "String", paramType = "query"),

    }
    )
    @GetMapping(value="/studentExamList")
    public Map<String,Object> studentExamList(String  studentId ,
                               String  pageSize ,
                               String  pageNo ){
        String pageBegin= String.valueOf ((Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize));

        List<Map<String,Object>> list = svr.currentStudentExamList(studentId,pageBegin,pageSize);
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        map.put("resultCode", "0");
        return map;
    }




    // 班级分数统计
    @ApiOperation( value = "班级分数统计 ",notes = " " +
            " 返回字段：{" +
            "    data : {" +
            "       examStudents : 考试学生数 " +
            "       avgScore : 平均分 " +
            "       maxScore : 最高分 " +
            "    } " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
               @ApiImplicitParam(name = "examId", value = "考试id", required = true, dataType = "String", paramType = "query"),
          }
    )
    @GetMapping(value="/classesExamScoreCensus")

  public Map<String,Object> classesExamScoreCensus(String examId){
        List<Map<String,Object>> list = svr.classesExamScoreCensus(examId);
        Map map = new HashMap();
        if (list == null || list.size()==0)
            map.put("data", null );
        else
            map.put("data", list.get(0) );

        map.put("resultMsg", "ok");
        map.put("resultCode", "0");
        return map;
    }


    int i=0;
    // 班级分数统计
    @ApiOperation( value = "班级分数统计柱状图 ",notes = " " +
            " 返回字段：{" +
            "    data :   " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "examId", value = "考试id", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/classesExamColumnScoreCensus")

    public Map<String,Object> classesExamColumnScoreCensus(String examId){
        List<Integer> scorelist = new ArrayList<Integer>();
        int totalScore =0;
        List<Map<String,Object>> list = svr.studentExamScoreList(examId);
        if (list != null && list.size()>0){
            totalScore=  Double.valueOf(list.get(0).get("score").toString()).intValue();
        }
        for (  i =0 ; i<=totalScore;){
            scorelist.add(
                    (int)   list.stream().filter(o ->  Double.valueOf(o.get("getScore").toString()) >= Double.valueOf(i)  &&
                              Double.valueOf(o.get("getScore").toString()) < Double.valueOf(i+10)
                           ).count()
            );
            i+=10;
        };
        Map map = new HashMap();
        map.put("data", scorelist );
        map.put("resultMsg", "ok");
        map.put("resultCode", "0");
        return map;


    }




    // 试卷分析
    @ApiOperation( value = "试卷分析 ",notes = " " +
            " 返回字段：{" +
            "    data :  [" +
            "           {" +
            "           defficulty： 难度 1.简单,2.中等,3.困难" +
            "           subjects  : 总题型数" +
            "           rightSubjects : 全对人数" +
            "           partSubjects : 部分答对人数" +
            "           wrongSubjects : 全错人数" +
            "           rightRate : 全对率  " +
            "         }" +
            "] " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "examId", value = "考试id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "studentId", value = "学生id", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/examPaperCensus")

    public Map<String,Object> examPaperCensus(String studentId,String examId){
        List<Map<String,Object>> list =svr.studentExamSubjectRate(studentId,examId);
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        map.put("resultCode", "0");
        return map;


    }


    // 题型得分分析
    @ApiOperation( value = "题型得分分析雷达图 ",notes = " " +
            " 返回字段：{" +
            "    data :  [" +
            "           {" +
            "           subjectExamClassName： 题型" +
            "           subjectExamNos  : 题号" +
            "           totalScore : 总分" +
            "           selfScore : 个人得分" +
            "           avgScore : 班级平均分" +
            "         }" +
            "] " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "examId", value = "考试id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "studentId", value = "学生id", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/studentExamRada")
    public Map<String,Object> studentExamRada(String studentId,String examId){
        List<Map<String,Object>> list =svr.studentExamRada(examId,studentId);
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        map.put("resultCode", "0");
        return map;
    }


}
