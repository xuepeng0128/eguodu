package com.yxp.eguodu.controller.dic;


import com.yxp.eguodu.entity.HabitUnit;
import com.yxp.eguodu.service.dic.HabitUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/dic/habitUnit", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class HabitUnitCtrl {
    @Autowired
    private HabitUnitService svr;


    @GetMapping(value="/habitUnitList")
    public List<HabitUnit>  habitUnitList(){
         return svr.habitUnitList();
    }

    @GetMapping(value="/inserthabitUnit")
    public Map<String,Object>  inserthabitUnit(String unitName){
        int d =svr.insertHabitUnit(new HashMap<String,Object>(){{
            put("unitName" , unitName);
        }}) ;
        if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;

    }

}
