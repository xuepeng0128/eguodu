package com.yxp.eguodu.wxcontroller.business;

import com.yxp.eguodu.common.queryparams.CircleQueryParams;
import com.yxp.eguodu.entity.Circle;
import com.yxp.eguodu.service.business.CircleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value="微信圈子",tags={"微信小程序圈子相关操作webapi接口"})
@CrossOrigin
@RestController
@RequestMapping(value = "/api/wxcircle",  produces = "application/json;charset=UTF-8")
public class WxCircleCtrl {

    @Autowired
    private CircleService svr;


    @ApiOperation( value = "按条件组合分页查询圈子(本学生未加入过的公开圈子) ",notes = "" +
            " 返回字段：{" +
            "    data : [{" +
            "           circleId, // 圈子id" +
            "         circleTitle, // 圈子标题 " +
            "            subTitle, // 副标题" +
            "       circleClassId, // 圈子类别id " +
            "       circleClassName, // 圈子类别 " +
            "          schoolId, // 学校编号" +
            "        schoolName, // 学校名称 " +
            "         classesId, // 班级编号" +
            "    buildTeacherId, // 建圈老师" +
            "  buildTeacherName, // 建圈老师名称" +
            "    buildStudentId, // 建圈学生" +
            "   buildStudentName , // 建圈学生名称" +
            "           buildTime, // 创建时间" +
            "                memo, // 圈子描述" +
            "              picUrl  // 圈子宣传画 " +
            "        }] , " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "circleTitle", value = "圈子标题", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "circleClassId", value = "圈子类别id", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "studentId", value = "学生id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNo", value = "页码", required = true, dataType = "String", paramType = "query")
    }
    )
    @GetMapping(value="/circleFindList")
    public Map<String ,Object> circleFindList(String circleTitle,String circleClassId,String studentId, String pageSize, String pageNo){
        String pageBegin= String.valueOf ((Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize));
        List<Map<String,Object>> list =svr.circleFindList( circleTitle,circleClassId,studentId,  pageSize, pageBegin);
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        return map;
    }


    @ApiOperation( value = "查询本学生当前已加入的圈子(不包含以前加入，现已退出的圈子)) ",notes = "" +
            " 返回字段：{" +
            "    data : [{" +
            "           circleId, // 圈子id" +
            "         circleTitle, // 圈子标题 " +
            "            subTitle, // 副标题" +
            "       circleClassId, // 圈子类别id " +
            "       circleClassName, // 圈子类别 " +
            "          schoolId, // 学校编号" +
            "        schoolName, // 学校名称 " +
            "         classesId, // 班级编号" +
            "    buildTeacherId, // 建圈老师" +
            "  buildTeacherName, // 建圈老师名称" +
            "    buildStudentId, // 建圈学生" +
            "   buildStudentName , // 建圈学生名称" +
            "           buildTime, // 创建时间" +
            "                memo, // 圈子描述" +
            "              picUrl  // 圈子宣传画" +
            "             closeMan,// 圈子关闭人" +
            "            closeTime,// 关闭时间" +
            "         closeReason, // 关闭原因" +
            "      circleProperty // 圈子性质1.私有，2.公开" +
            "        }] , " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentId", value = "学生id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNo", value = "页码", required = true, dataType = "String", paramType = "query")
    }
    )
    @GetMapping(value="/circleHaveJoinedList")
    public Map<String ,Object> circleHaveJoinedList(String studentId, String pageSize, String pageNo){
        String pageBegin= String.valueOf ((Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize));
        List<Map<String,Object>> list =svr.circleHaveJoinedList( studentId,  pageSize, pageBegin);
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        return map;
    }


    @ApiOperation( value = " 查询本学生家长建的圈子 ",notes = "" +
            " 返回字段：{" +
            "    data : [{" +
            "           circleId, // 圈子id" +
            "         circleTitle, // 圈子标题 " +
            "            subTitle, // 副标题" +
            "       circleClassId, // 圈子类别id " +
            "       circleClassName, // 圈子类别 " +
            "           buildTime, // 创建时间" +
            "                memo, // 圈子描述" +
            "              picUrl  // 圈子宣传画 " +
            "             closeMan,// 圈子关闭人" +
            "            closeTime,// 关闭时间" +
            "         closeReason, // 关闭原因" +
            "      circleProperty // 圈子性质1.私有，2.公开" +
            "        }] , " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentId", value = "学生id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNo", value = "页码", required = true, dataType = "String", paramType = "query")
    }
    )
    @GetMapping(value="/studentBuildCircleList")

    public Map<String,Object>  studentBuildCircleList(String studentId, String pageSize, String pageNo){

        String pageBegin= String.valueOf ((Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize));
        List<Map<String,Object>> list =svr.studentBuildCircleList( studentId,  pageSize, pageBegin);
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        return map;
    }

    @ApiOperation( value = " 学生家长建圈 ",notes = "  建圈时，只需保证( circleId,circleTitle," +
            "subTitle,circleClassId,buildStudentId,memo,picUrl,circleProperty) 这些字段有值即可" +
            " 返回字段：{" +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "circle", value = "圈子类", required = true, dataType = "Circle"),
    }
    )
    @PostMapping(value="/studentBuildCircle")
    public Map<String,Object> studentBuildCircle( @RequestBody  Circle circle){

        int d = svr.studentBuildCircle(circle);
        if (d>0)
            return new HashMap<String,Object>(){{put("resultMsg","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("resultMsg","fail") ;}} ;
    }

    // 学生家长圈子修改

    @ApiOperation( value = " 学生家长圈子修改 ",notes = "  修改圈时，只根据circleId修改这些字段( circleTitle," +
            "subTitle,circleClassId,memo,picUrl,circleProperty)" +
            " 返回字段：{" +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "circle", value = "圈子类", required = true, dataType = "Circle"),
    }
    )
    @PostMapping(value="/updateStudentBuildCircle")
    public Map<String,Object> updateStudentBuildCircle(@RequestBody  Circle circle){
        int d = svr.updateStudentBuildCircle(circle);
        if (d>=0)
            return new HashMap<String,Object>(){{put("resultMsg","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("resultMsg","fail") ;}} ;
    }


    //学生加入圈子
    @ApiOperation( value = " 学生加入圈子 ",notes = " " +
            " 返回字段：{" +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "circleId", value = "圈子id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "studentId", value = "学生id", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/studentJoinCircle")
    public Map<String,Object> studentJoinCircle(String circleId,String studentId){
        int d = svr.studentJoinCircle(circleId,studentId);
        if (d>=0)
            return new HashMap<String,Object>(){{put("resultMsg","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("resultMsg","fail") ;}} ;
    }

    // 学生退出圈子（有学籍，班级, 建圈老师 的圈子为 学校建的圈子，不能自行退出）
    @ApiOperation( value = " 学生退出圈子",notes = "（有学籍，班级, 建圈老师 的圈子为 学校建的圈子，不能自行退出） " +
            " 返回字段：{" +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "circleId", value = "圈子id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "studentId", value = "学生id", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/studentOutOfCircle")
    public Map<String,Object> studentOutOfCircle(String circleId,String studentId){

        int d = svr.studentOutOfCircle(circleId,studentId);
        if (d>=0)
            return new HashMap<String,Object>(){{put("resultMsg","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("resultMsg","fail") ;}} ;

    }
}
