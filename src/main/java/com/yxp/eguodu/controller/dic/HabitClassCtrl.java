package com.yxp.eguodu.controller.dic;

import com.yxp.eguodu.entity.CorpDuty;
import com.yxp.eguodu.entity.HabitClass;
import com.yxp.eguodu.service.dic.CorpDutyService;
import com.yxp.eguodu.service.dic.HabitClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/dic/habitclass", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class HabitClassCtrl {

    @Autowired
    private HabitClassService svr;

    @GetMapping(value="/habitClassList")
    public List<HabitClass> habitClassList(){
        List<HabitClass> list= svr.habitClassList();
        return list;
    }



    @PostMapping(value="/insertHabitClass")
    public Map<String,Object> insertHabitClass(@RequestBody HabitClass habitClass){
        int d = svr.insertHabitClass(habitClass);
        if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    @PostMapping(value="/updateHabitClass")
    public Map<String, Object> updateHabitClass(@RequestBody HabitClass habitClass){
        int d = svr.updateHabitClass(habitClass);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    @GetMapping(value="/deleteHabitClass")
    public Map<String, Object> deleteHabitClass(String habitClassId){

        int d =   svr.deleteHabitClass(habitClassId);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;

    }







}
