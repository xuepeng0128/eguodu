package com.yxp.eguodu.wxcontroller;

import com.yxp.eguodu.entity.ClassesStudent;
import com.yxp.eguodu.service.basemsg.ClassesService;
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
import java.util.Optional;

@Api(value="微信基础数据",tags={"微信小程序用各项基础数据webapi接口"})
@CrossOrigin
@RestController
@RequestMapping(value = "/api/wxbasemsg",  produces = "application/json;charset=UTF-8")
public class WxBaseMsgCtrl {
    @Autowired
    private ClassesService classesService;
    @ApiOperation( value = "获取学生当前所在学校，年级，班级",notes = "" +
            " 返回字段：{" +
            "    data : {" +
            "            schoolId, // 学校编号" +
            "           schoolName, // 学校名称" +
            "           classesId, // 班级编号" +
            "           grade, //   学籍(全日制学校)" +
            "          classes, // 班级() " +
            "          classesName //班级名称(培训机构用) " +
            "          schoolStyle // 1 小学,2.初中,3.幼儿园 " +
            "        }  ,   " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentId", value = "学籍号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "schoolId", value = "学校编号", required = true, dataType = "String", paramType = "query"),

    }
    )
    @GetMapping(value="/findNowClassesByStudentId")
   public Map<String,Object> findNowClassesByStudentId(String studentId, String schoolId){
        List<Map<String,Object>> list = classesService.findNowClassesByStudent(studentId,schoolId);
        Map map = new HashMap();
        map.put("data", Optional.ofNullable(list.get(0)).orElse(null) );
        map.put("resultMsg", "ok");
        return map;
    }







}
