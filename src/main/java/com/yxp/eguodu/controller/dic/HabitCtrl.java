package com.yxp.eguodu.controller.dic;

import com.yxp.eguodu.entity.Habit;
import com.yxp.eguodu.service.dic.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 次数模式，数量模式，时间模式
 */
@RestController
@RequestMapping(value = "/api/dic/habit", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class HabitCtrl {
    @Autowired
    private HabitService svr;

    @GetMapping(value="/habitList")
    public List<Habit> HabitList(){
        List<Habit> list= svr.habitList();
        return list;
    }



    @PostMapping(value="/insertHabit")
    public Map<String,Object> insertHabit(@RequestBody Habit Habit){
        int d = svr.insertHabit(Habit);
        if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    @PostMapping(value="/updateHabit")
    public Map<String, Object> updateHabit(@RequestBody Habit Habit){
        int d = svr.updateHabit(Habit);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    @GetMapping(value="/deleteHabit")
    public Map<String, Object> deleteHabit(String HabitId){
        int d =   svr.deleteHabit(HabitId);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;

    }
}
