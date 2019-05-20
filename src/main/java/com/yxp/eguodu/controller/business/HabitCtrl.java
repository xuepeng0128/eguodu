package com.yxp.eguodu.controller.business;

import com.yxp.eguodu.common.queryparams.HabitQueryParams;
import com.yxp.eguodu.common.queryparams.InsertExamHabitParams;
import com.yxp.eguodu.entity.Habit;
import com.yxp.eguodu.entity.HabitExam;
import com.yxp.eguodu.service.business.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/business/habit", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class HabitCtrl {

    @Autowired
    private HabitService svr;
    @GetMapping(value="/habitList")
    public List<Habit> habitList(HabitQueryParams habitQueryParams){
        return svr.habitList(habitQueryParams);
    }
    @GetMapping(value="/habitListTotal")
    public Map<String,Object> habitListTotal(HabitQueryParams habitQueryParams){

        Map<String,Object> re= new HashMap<String,Object>();
        re.put("total", Integer.parseInt( svr.habitListTotal(habitQueryParams).get(0).get("total").toString()));
        return re;
    }


    @PostMapping(value="/insertExamHabit")
    public Map<String,Object> insertExamHabit(@RequestBody  InsertExamHabitParams insertExamHabitParams){
       int d = svr.insertExamHabit(insertExamHabitParams.getHabitExam(),insertExamHabitParams.getHabits(),insertExamHabitParams.getStudentIds());
        if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }
    @PostMapping(value="/insertNoExamHabit")
    public Map<String,Object> insertNoExamHabit(@RequestBody  InsertExamHabitParams insertExamHabitParams){
        int d = svr.insertNoExamHabit(insertExamHabitParams.getHabits().get(0),insertExamHabitParams.getStudentIds());
        if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    public Map<String,Object> studentPutCard( String habitId ,  String studentId){
        return null;
    }

}
