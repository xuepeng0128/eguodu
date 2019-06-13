package com.yxp.eguodu.wxcontroller;

import com.alibaba.fastjson.JSONObject;
import com.yxp.eguodu.entity.SysInformation;
import com.yxp.eguodu.service.system.SysInformationService;
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

@Api(value="微信系统信息",tags={"微信系统信息"})
@CrossOrigin
@RestController
@RequestMapping(value = "/api/system",  produces = "application/json;charset=UTF-8")
public class WxSystemCtrl {
    @Autowired
    private SysInformationService svr;
    @ApiOperation( value = "根据最后一条系统通知",notes = "" +
            " 返回字段：{" +
            "    data : sysInformation 类 ,   " +
            "    resultMsg : 'ok' ：成功 ，否则返回错误信息" +
            "    resultCode : '0 : 成功,1 : 小程序code 无效, 2. openId 获取异常 ,3.openId 无效 " +
            "}")
    @ApiImplicitParams({
       }
    )
    @GetMapping(value="/getSysInformation")
    public Map<String,Object> getSysInformation(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<SysInformation> list =svr.sysInformationList("0","1");
        try{
           if(list != null && list.size()>0 )
            map.put("data",list.get(0));
           else
               map.put("data",null);
            map.put("resultMsg","ok");
            map.put("resultCode","0");
        }catch (Exception ex){
            map.put("data",ex.toString());
            map.put("resultMsg","fail");
            map.put("resultCode","2");
        }
        return  map;
    }




}
