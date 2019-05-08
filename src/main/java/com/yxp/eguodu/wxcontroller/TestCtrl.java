package com.yxp.eguodu.wxcontroller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(value="测试",tags={"测试webapi 接口"})
@CrossOrigin
@RestController
@RequestMapping(value = "/api/test",  produces = "application/json;charset=UTF-8")
public class TestCtrl {

    @ApiOperation( value = "保存身份证信息",notes = "" +
            " 返回字段：{" +
            "   data : null ,   " +
            "    resultCode," +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paperId", value = "身份证号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sex", value = "性别(1 男 2 女)", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "birthday", value = "出生日期( yyyy-mm-dd)", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "address", value = "地址", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "photo", value = "身份证照 base64", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "nativeId", value = "民族编号", required = true, dataType = "String", paramType = "query"),
    }
    )
    @GetMapping(value="/aa")
    public Map<String,Object> aa(){

        return new HashMap<String,Object>(){{
            put("result","ok");
        }};
    }
}
