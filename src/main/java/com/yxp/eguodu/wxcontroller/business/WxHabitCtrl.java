package com.yxp.eguodu.wxcontroller.business;

import com.yxp.eguodu.entity.HabitTemplate;
import com.yxp.eguodu.service.dic.HabitTemplateService;
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


@Api(value="微信习惯",tags={"微信小程序习惯相关操作webapi接口"})
@CrossOrigin
@RestController
@RequestMapping(value = "/api/wxhabit",  produces = "application/json;charset=UTF-8")
public class WxHabitCtrl {
    @Autowired
    private HabitTemplateService habitTemplateService;


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


//    @ApiOperation( value = "  ",notes = " " +
//            " 返回字段：{" +
//            "    data :  HabitTemplate 对象数组 " +
//            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
//            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
//            "}")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "pageNo", value = "页码", required = true, dataType = "String", paramType = "query"),
//            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = true, dataType = "String", paramType = "query"),
//    }
//    )







}
