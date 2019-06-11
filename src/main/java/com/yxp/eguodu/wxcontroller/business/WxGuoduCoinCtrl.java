package com.yxp.eguodu.wxcontroller.business;


import com.yxp.eguodu.entity.GuoduBill;
import com.yxp.eguodu.service.business.CircleService;
import com.yxp.eguodu.service.business.GuoduCoinService;
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

@Api(value="微信果度币",tags={"微信小程序果度币相关操作webapi接口"})
@CrossOrigin
@RestController
@RequestMapping(value = "/api/wxguoducoin",  produces = "application/json;charset=UTF-8")
public class WxGuoduCoinCtrl {
    @Autowired
    private GuoduCoinService svr;


    @ApiOperation( value = "查询该学生果度账单 ",notes = "" +
            " 返回字段：{" +
            "    data :  , " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentId", value = "学生id", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNo", value = "页码", required = true, dataType = "String", paramType = "query")
    }
    )
    @GetMapping(value="/guoduBillList")
    public Map<String ,Object> guoduBillList(String studentId, String pageSize, String pageNo){
        String pageBegin= String.valueOf ((Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize));
        List<GuoduBill> list =svr.guoduBillList( studentId, pageBegin, pageSize );
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        return map;
    }





    @ApiOperation( value = "查询该学生果度总数 ",notes = "" +
            " 返回字段：{" +
            "    data : total , " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentId", value = "学生id", required = false, dataType = "String", paramType = "query"),
     }
    )
    @GetMapping(value="/totalGuoduCoin")
    public Map<String ,Object> totalGuoduCoin(String studentId){
        List<GuoduBill> list =svr.guoduBillList( studentId, "0", "20000" );
        Map map = new HashMap();
        double total= list.stream().mapToDouble(o->o.getGuoduCoin()).sum();
        map.put("data", total );
        map.put("resultMsg", "ok");
        return map;
    }





}
