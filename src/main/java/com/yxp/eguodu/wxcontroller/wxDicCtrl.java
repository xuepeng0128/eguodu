package com.yxp.eguodu.wxcontroller;

import com.yxp.eguodu.entity.Nation;
import com.yxp.eguodu.entity.RelationShip;
import com.yxp.eguodu.service.basemsg.SchoolService;
import com.yxp.eguodu.service.dic.NationService;
import com.yxp.eguodu.service.dic.RelationShipService;
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
import java.util.stream.Collectors;

@Api(value="微信字典",tags={"微信小程序用各项字典webapi接口"})
@CrossOrigin
@RestController
@RequestMapping(value = "/api/wxdic",  produces = "application/json;charset=UTF-8")
public class wxDicCtrl {

    @Autowired
    private NationService nationsvr;

    @ApiOperation( value = "获取省列表",notes = "获取各省列表" +
            " 返回字段：{" +
            "    data : Nation 类  ,   " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "}")
    @ApiImplicitParams({
    }
    )
    @GetMapping(value="/provinceList")
    public Map<String,Object> provinceList(){
        List<Nation> list= nationsvr.nationList().stream().filter(o-> o.getNationId().contains("0000000000")).collect(Collectors.toList());
       Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        return map;
    }

    @ApiOperation( value = "获取省所在市列表",notes = "" +
            " 返回字段：{" +
            "    data : Nation 类  ,   " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "provinceId", value = "省编号", required = true, dataType = "String", paramType = "query"),

    }
    )
    @GetMapping(value="/cityList")
    public Map<String,Object> cityList(String provinceId){
        List<Nation> list= nationsvr.nationList().stream().filter(o-> !o.getNationId().contains("0000000000")
           && o.getNationId().contains("00000000") && o.getNationId().startsWith(provinceId.substring(0,2))
        ).collect(Collectors.toList());
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        return map;
    }

    @ApiOperation( value = "获取市所在区列表",notes = "" +
            " 返回字段：{" +
            "    data : Nation 类  ,   " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cityId", value = "市编号", required = true, dataType = "String", paramType = "query"),

    }
    )
    @GetMapping(value="/districtList")
    public Map<String,Object> districtList(String cityId){
        List<Nation> list= nationsvr.nationList().stream().filter(o-> !o.getNationId().contains("00000000")
                && o.getNationId().contains("000000") && o.getNationId().startsWith(cityId.substring(0,4))
        ).collect(Collectors.toList());
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        return map;
    }


    @Autowired
    private RelationShipService relationShipService;

    @ApiOperation( value = "获取亲属关系列表",notes = "" +
            " 返回字段：{" +
            "    data : RelationShip 对象数组  ,   " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "}")
    @ApiImplicitParams({
    }
    )
    @GetMapping(value="/relationShipList")
    public Map<String,Object> relationShipList(){
        List<RelationShip> list=  relationShipService.relationShipList();
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        return map;
    }

    @Autowired
    private SchoolService schoolService;
    @ApiOperation( value = "根据区编号，学校名称 查找学校",notes = "" +
            " 返回字段：{" +
            "    data : [{" +
            "              schoolId : 学校编号" +
            "              schoolName : 学校名称 " +
            "           }],   " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "districtId", value = "区县编号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "schoolName", value = "学校名称(模糊查找)", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/schoolListByDistrictAndName")
    public Map<String, Object> schoolListByDistrictAndName(String districtId, String schoolName){
        List<Map<String,Object>> list = schoolService.schoolListByAreaAndName(districtId,schoolName);
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        return map;
    }

}
