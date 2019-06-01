package com.yxp.eguodu.controller.dic;

import com.yxp.eguodu.entity.Nation;
import com.yxp.eguodu.service.dic.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/nation", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class NationCtrl {
    @Autowired
    private NationService svr;

    @GetMapping(value="/nationList")
    public List<Nation> nationList(){
        List<Nation> list= svr.nationList();
        return list;
    }




}
