package com.yxp.eguodu.controller.dic;

import com.yxp.eguodu.entity.TeacherDuty;
import com.yxp.eguodu.service.dic.TeacherDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/dic/teacherduty", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class TeacherDutyCtrl {

    @Autowired
    private TeacherDutyService svr;

    @GetMapping(value="/teacherDutyList")
    public List<TeacherDuty> teacherDutyList(){
        List<TeacherDuty> list= svr.teacherDutyList();
        return list;
    }



    @PostMapping(value="/insertTeacherDuty")
    public Map<String,Object> insertTeacherDuty(@RequestBody TeacherDuty teacherDuty){
        int d = svr.insertTeacherDuty(teacherDuty);
        if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    @PostMapping(value="/updateTeacherDuty")
    public Map<String,Object> updateTeacherDuty(@RequestBody TeacherDuty teacherDuty){
        int d = svr.updateTeacherDuty(teacherDuty);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    @GetMapping(value="/deleteTeacherDuty")
    public Map<String,Object> deleteTeacherDuty(String teacherDutyId){
        int d =   svr.deleteTeacherDuty(teacherDutyId);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }
}
