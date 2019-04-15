package com.yxp.eguodu.controller.dic;

import com.yxp.eguodu.entity.CorpDuty;
import com.yxp.eguodu.service.dic.CorpDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/corpduty", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class CorpDutyCtrl {
    @Autowired
    private CorpDutyService svr;

    @GetMapping(value="/corpDutyList")
    public List<CorpDuty> corpDutyList(){
        List<CorpDuty> list= svr.corpDutyList();
        return list;
    }



    @PostMapping(value="/insertCorpDuty")
    public String insertCorpDuty(@RequestBody CorpDuty corpDuty){
        int d = svr.insertCorpDuty(corpDuty);
        if (d>0)
            return "ok";
        else
            return "fail";
    }

    @PostMapping(value="/updateCorpDuty")
    public String updateCorpDuty(@RequestBody CorpDuty corpDuty){
        int d = svr.updateCorpDuty(corpDuty);
        if (d>=0)
            return "ok";
        else
            return "fail";
    }

    @GetMapping(value="/deleteCorpDuty")
    public String deleteCorpDuty(String corpDutyId){

         int d =   svr.deleteCorpDuty(corpDutyId);
        if (d>=0)
            return "ok";
        else
            return "fail";

    }


}
