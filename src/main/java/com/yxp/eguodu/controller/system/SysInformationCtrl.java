package com.yxp.eguodu.controller.system;

import com.yxp.eguodu.entity.SysInformation;
import com.yxp.eguodu.service.system.SysInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/system/sysinformation", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class SysInformationCtrl {
    @Autowired
    private SysInformationService svr;

    @GetMapping(value="/sysInformationList")
    public List<SysInformation> sysInformationList(String pageBegin , String pageSize){
        List<SysInformation> list= svr.sysInformationList(pageBegin,pageSize);
        return list;
    }

    @PostMapping(value = "/insertInformation")
    public Map<String,Object> insertInformation(SysInformation sysInformation){
        int d = svr.insertInformation(sysInformation);
        if (d>=0)
            return  new HashMap<String,Object>()
            {{
                put( "result","ok");
            }};

        else
            return  new HashMap<String,Object>()
            {{
                put( "result","ok");
            }};
    }



}
