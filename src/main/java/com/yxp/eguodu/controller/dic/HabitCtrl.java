package com.yxp.eguodu.controller.dic;

import com.yxp.eguodu.entity.Habit;
import com.yxp.eguodu.service.dic.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String insertHabit(@RequestBody Habit Habit){
        int d = svr.insertHabit(Habit);
        if (d>0)
            return "ok";
        else
            return "fail";
    }

    @PostMapping(value="/updateHabit")
    public String updateHabit(@RequestBody Habit Habit){
        int d = svr.updateHabit(Habit);
        if (d>=0)
            return "ok";
        else
            return "fail";
    }

    @GetMapping(value="/deleteHabit")
    public String deleteHabit(String HabitId){
        int d =   svr.deleteHabit(HabitId);
        if (d>=0)
            return "ok";
        else
            return "fail";

    }
}
