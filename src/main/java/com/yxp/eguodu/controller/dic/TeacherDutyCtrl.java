package com.yxp.eguodu.controller.dic;

import com.yxp.eguodu.entity.TeacherDuty;
import com.yxp.eguodu.service.dic.TeacherDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String insertTeacherDuty(@RequestBody TeacherDuty teacherDuty){
        int d = svr.insertTeacherDuty(teacherDuty);
        if (d>0)
            return "ok";
        else
            return "fail";
    }

    @PostMapping(value="/updateTeacherDuty")
    public String updateTeacherDuty(@RequestBody TeacherDuty teacherDuty){
        int d = svr.updateTeacherDuty(teacherDuty);
        if (d>=0)
            return "ok";
        else
            return "fail";
    }

    @GetMapping(value="/deleteTeacherDuty")
    public String deleteTeacherDuty(String teacherDutyId){

        int d =   svr.deleteTeacherDuty(teacherDutyId);
        if (d>=0)
            return "ok";
        else
            return "fail";

    }

}
