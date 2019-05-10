package com.yxp.eguodu.controller.business;

import com.yxp.eguodu.service.business.SchoolExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api/business/schoolexam", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class SchoolExamCtrl {
      @Autowired
      private SchoolExamService svr;




    @RequestMapping(value = "/exportExamExcelTemplate",produces = {"application/vnd.ms-excel;charset=UTF-8"})
    @ResponseBody
    public String examExcelTemplate( HttpServletResponse response,
                                     @RequestParam(value="schoolId",required = true) String schoolId,
                                     @RequestParam(value="subjectFullScores",required = true)String subjectFullScores
                                     ){
          return svr.exportExamTemplate(response,subjectFullScores,schoolId);
    }

}
