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
    public List<SysInformation> sysInformationList(String pageNo , String pageSize){
        String pageBegin= String.valueOf ((Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize));
        List<SysInformation> list= svr.sysInformationList(pageBegin,pageSize);
        return list;
    }

    @GetMapping(value="/sysInformationListTotal")
    public Map<String, Object> sysInformationListTotal() {
        List<Map<String,Object>> list = svr.sysInformationListTotal();
        Map<String,Object> re= new HashMap<String,Object>();
        re.put("total",Integer.parseInt( list.get(0).get("total").toString()));
        return re;
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
