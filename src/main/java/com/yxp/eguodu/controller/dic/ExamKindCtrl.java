package com.yxp.eguodu.controller.dic;

import com.yxp.eguodu.entity.ExamKind;
import com.yxp.eguodu.service.dic.ExamKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dic/examkind", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class ExamKindCtrl {
    @Autowired
    private ExamKindService svr;


    @GetMapping(value="/examKindList")
    public List<ExamKind> examKindList(){
          return svr.examKindList();
    }



}
