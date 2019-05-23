package com.yxp.eguodu.controller.system;

import com.alibaba.fastjson.JSON;
import com.yxp.eguodu.entity.SystemParams;
import com.yxp.eguodu.service.system.WxParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/system/wxparams", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class WxParamsCtrl {
    @Autowired
    private WxParamsService svr;

    @GetMapping(value="/wxparams")
    public SystemParams wxparams(){
        List<Map<String, Object>> list = svr.wxParamsList();
        String paramsstr="";
        if (list==null  || list.size()==0)
        {
            paramsstr="";
        }else {
            paramsstr=list.get(0).get("param").toString();
        }
        SystemParams p = null;
        if (! paramsstr.equals(""))
        {
            p= JSON.parseObject(paramsstr,SystemParams.class);
        }
        return p;
    }

    @PostMapping(value="/insertWxparams")
    public Map<String,Object> insertWxParams(@RequestBody SystemParams params){
        svr.insertWxParams(new HashMap<String,Object>(){{
             put("param",JSON.toJSONString(params));
        }});
        return new HashMap<String,Object>(){{
           put("result","ok");
        }};
    }
}
