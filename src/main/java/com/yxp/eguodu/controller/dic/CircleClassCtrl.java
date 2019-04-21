package com.yxp.eguodu.controller.dic;

import com.yxp.eguodu.entity.CircleClass;
import com.yxp.eguodu.entity.CorpDuty;
import com.yxp.eguodu.service.dic.CircleClassService;
import com.yxp.eguodu.service.dic.CorpDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
