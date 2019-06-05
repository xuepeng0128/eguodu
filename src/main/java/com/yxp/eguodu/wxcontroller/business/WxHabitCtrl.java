package com.yxp.eguodu.wxcontroller.business;

import com.yxp.eguodu.common.queryparams.HabitQueryParams;
import com.yxp.eguodu.common.queryparams.InsertExamHabitParams;
import com.yxp.eguodu.entity.Habit;
import com.yxp.eguodu.entity.HabitTemplate;
import com.yxp.eguodu.entity.StudentPutCard;
import com.yxp.eguodu.service.business.HabitService;
import com.yxp.eguodu.service.dic.HabitTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


@Api(value="微信习惯",tags={"微信小程序习惯相关操作webapi接口"})
@CrossOrigin
@RestController
@RequestMapping(value = "/api/wxhabit",  produces = "application/json;charset=UTF-8")
public class WxHabitCtrl {
    @Autowired
    private HabitTemplateService habitTemplateService;
    @Autowired
    private HabitService svr;

    @ApiOperation( value = " 习惯资源池 ",notes = " " +
            " 返回字段：{" +
            "    data :  HabitTemplate 对象数组 " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/habitTemplateList")
    public Map  habitTemplateList(String pageNo,String pageSize){
        String pageBegin= String.valueOf ((Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize));
        List<HabitTemplate> list =habitTemplateService.habitTemplateList( new HashMap<String,Object>(){{
            put("pageSize",pageSize);
            put("pageBegin",pageBegin);
        }});
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        map.put("resultCode", "0");
        return map;
    }



    @ApiOperation( value = "家长建立习惯",notes = " " +
            " 返回字段：{" +
            "    data :  " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效,,9.写数据库错误 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "insertExamHabitParams", value = "建立习惯类", required = true, dataType = "InsertExamHabitParams")
    }
    )
    @PostMapping(value="/studentBuildHabit")
    public Map<String,Object> studentBuildHabit(@RequestBody InsertExamHabitParams insertExamHabitParams){
        int d = svr.insertNoExamHabit(insertExamHabitParams.getHabits().get(0),insertExamHabitParams.getStudentIds());
        Map map = new HashMap();
        if (d>0){
            map.put("resultMsg", "ok");
            map.put("resultCode", "0");
        }else {
            map.put("resultMsg", "ok");
            map.put("resultCode", "9");
        }
      return map ;
    }


    @ApiOperation( value = "根据圈子id查询圈内习惯  ",notes = " " +
            " 返回字段：{" +
            "    data :  Habit 对象数组 " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "circleId", value = "圈子id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNo", value = "页码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/habitsInCircle")
   public Map<String,Object> habitsInCircle(String circleId,String pageSize,String pageNo){
        String pageBegin= String.valueOf ((Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize));
        HabitQueryParams habitQueryParams= new HabitQueryParams(  null,  null,  circleId,  null,  null,  null,
                null,  null,  null,  null,  null,null,null,
                pageSize,  pageNo,  pageBegin);
        List<Habit> list= svr.habitList(habitQueryParams);
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        map.put("resultCode", "0");
        return map;
   }

    @ApiOperation( value = "根据学生id查询所有参与的打卡习惯 ",notes = " " +
            " 返回字段：{" +
            "    data :  " +
            "        {" +
            "           'circleInfo': {circleId ,circleTitle}, habits :[]" +
            "        } " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentId", value = "学生id", required = true, dataType = "String", paramType = "query")
    }
    )
    @GetMapping(value="/studentAllHabits")
    public Map<String,Object> studentAllHabits(String studentId){

        HabitQueryParams habitQueryParams= new HabitQueryParams(  null,  null,  null,  null,  null,  null,
                null,  null,  null,  null,  null,studentId,null,
                "1000",  "1",  "0");
        List<Habit> list= svr.habitList(habitQueryParams);
        List<Map<String,Object>> resultlist=new ArrayList<Map<String,Object>>();
        String nowCircleId="";
        for(Habit habit : list.stream().sorted(Comparator.comparing(Habit::getCircleId)).collect(Collectors.toList())){
            if (!habit.getCircleId().equals(nowCircleId)){
                resultlist.add(new HashMap<String,Object>() {{
                    put("circleinfo", new HashMap<String,String>(){{
                        put("circleId", habit.getCircleId());
                        put("circleTitle", habit.getCircleTitle());
                    }});
                    put("habits",new ArrayList<Habit>());
                }});
                nowCircleId=habit.getCircleId();
            }
        }

        for(Habit habit : list.stream().sorted(Comparator.comparing(Habit::getCircleId)).collect(Collectors.toList())){
            ((ArrayList)  resultlist.stream().filter( o->  ((Map)o.get("circleinfo")).get("circleId").toString().equals(habit.getCircleId()))
                    .findFirst().orElse(new HashMap<String,Object>()).get("habits")).add(habit);
        }

        Map map = new HashMap();
        map.put("data", resultlist );
        map.put("resultMsg", "ok");
        map.put("resultCode", "0");
        return map;
    }




    @ApiOperation( value = "根据学生id查询当天的打卡任务的习惯  ",notes = " " +
            " 返回字段：{" +
            "    data :  Habit 对象数组 " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentId", value = "学生id", required = true, dataType = "String", paramType = "query")
    }
    )
    @GetMapping(value="/studentTodayHabits")
    public Map<String,Object> studentTodayHabits(String studentId){

        HabitQueryParams habitQueryParams= new HabitQueryParams(  null,  null,  null,  null,  null,  null,
                null,  null,  null,  null,  null,null ,studentId,
               "1000",  "1",  "0");
        List<Habit> list= svr.habitList(habitQueryParams);

        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        map.put("resultCode", "0");
        return map;
    }



    @ApiOperation( value = "学生准备打卡,获取预先设置的打卡信息 ",notes = " " +
            " 返回字段：{" +
            "    data :  studentPutCard 对象 " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "habitId", value = "习惯id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "studentId", value = "学生id", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/studentPreparePutCard")
    public Map<String,Object> studentPreparePutCard(String habitId,String studentId){

        List<StudentPutCard> list= svr.currentStudentPrepareHabitPutCard(habitId,studentId);
        StudentPutCard studentPutCard=list.stream().findFirst().orElse(null);
        Map map = new HashMap();
        map.put("data", studentPutCard );
        map.put("resultMsg", "ok");
        map.put("resultCode", "0");
        return map;
    }









    @ApiOperation( value = "学生打卡 ",notes = " " +
            " 返回字段：{" +
            "    data :  HabitTemplate 对象数组 " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentPutCard", value = "打卡类", required = true, dataType = "StudentPutCard")
    }
    )
    @PostMapping(value="/studentPutCard")
    public Map<String,Object> studentPutCard(@RequestBody StudentPutCard studentPutCard){
        int d = svr.studentPutCard(studentPutCard);
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
