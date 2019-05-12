package com.yxp.eguodu.controller.system;

import com.alibaba.fastjson.JSON;
import com.yxp.eguodu.service.system.WxParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/system/wxparams", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class WxParamsCtrl {
    @Autowired
    private WxParamsService svr;

    @GetMapping(value="/wxparams")
    public Map<String,Object> wxparams(){
        String paramsstr = svr.wxParamsList().stream().findFirst().orElse(new HashMap<String,Object>()).get("param").toString();
        return JSON.parseObject(paramsstr,Map.class);
    }

    @PostMapping(value="/insertWxparams")
    public Map<String,Object> insertWxParams(String paramstr){
        svr.insertWxParams(new HashMap<String,Object>(){{
             put("param",paramstr);
        }});
        return new HashMap<String,Object>(){{
           put("result","ok");
        }};
    }
}
