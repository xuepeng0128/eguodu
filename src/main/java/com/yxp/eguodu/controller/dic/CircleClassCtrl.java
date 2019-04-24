package com.yxp.eguodu.controller.dic;

import com.yxp.eguodu.entity.CircleClass;
import com.yxp.eguodu.entity.CorpDuty;
import com.yxp.eguodu.service.dic.CircleClassService;
import com.yxp.eguodu.service.dic.CorpDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping(value = "/api/dic/circleclass", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class CircleClassCtrl {
    @Autowired
    private CircleClassService svr;

    @GetMapping(value="/circleClassList")
    public List<CircleClass> circleClassList(){
        List<CircleClass> list= svr.circleClassList();
        return list;
    }



    @PostMapping(value="/insertCircleClass")
    public Map<String,Object> insertCircleClass(@RequestBody CircleClass circleClass){
        int d = svr.insertCircleClass(circleClass);
        if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    @PostMapping(value="/updateCircleClass")
    public String updateCircleClass(@RequestBody CircleClass circleClass){
        int d = svr.updateCircleClass(circleClass);
        if (d>=0)
            return "ok";
        else
            return "fail";
    }

    @GetMapping(value="/deleteCircleClass")
    public String deleteCircleClass(String circleClassId){

        int d =   svr.deleteCircleClass(circleClassId);
        if (d>=0)
            return "ok";
        else
            return "fail";

    }

}
