package com.yxp.eguodu.controller.business;

import com.yxp.eguodu.common.queryparams.ExamQueryParams;
import com.yxp.eguodu.entity.Exam;
import com.yxp.eguodu.entity.SubExam;
import com.yxp.eguodu.service.business.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/business/exam", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class ExamCtrl {
    @Autowired
    private ExamService svr;
    @GetMapping(value="/examList")
    public List<Exam> examList(String  classesIds , String  schoolId ,
                               String  pageBegin , String  pageSize ,
                               String  pageNo ){
        if(!classesIds.equals(""))
            classesIds = "'" +classesIds.replace(",","','") +"'";
        ExamQueryParams examQueryParams = new ExamQueryParams(classesIds,schoolId,pageBegin,pageSize,pageNo);
        List<Exam> list = svr.examList(examQueryParams);
        return list;
    }
    @GetMapping(value="/examListTotal")
   public Map<String,Object> examListTotal(String  classesIds , String  schoolId ,
                                           String  pageBegin , String  pageSize ,
                                           String  pageNo ){
        if(!classesIds.equals(""))
            classesIds = "'" +classesIds.replace(",","','") +"'";
        ExamQueryParams examQueryParams = new ExamQueryParams(classesIds,schoolId,pageBegin,pageSize,pageNo);
        Map<String,Object> re= new HashMap<String,Object>();
        re.put("total", Integer.parseInt( svr.examListTotal(examQueryParams).get(0).get("total").toString()));
        return re;
    }

    @PostMapping(value="/saveExam")
    public Map<String,Object> saveExam(@RequestBody Exam exam){
        int d =svr.saveExam(exam);
        if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }
    @PostMapping(value="/deleteExam")
   public  Map<String,Object> deleteExam(String examId){
       int d =svr.deleteExam(examId);
       if (d>0)
           return new HashMap<String,Object>(){{put("result","ok") ;}} ;
       else
           return new HashMap<String,Object>(){{put("result","fail") ;}} ;
   }

   @GetMapping(value = "/subExamList")
   public List<SubExam> subExamList(String examId){
       List<SubExam> list =svr.subExamList(examId);
       return list;
   }


    @GetMapping(value = "/initSubExamList")
    public List<SubExam> initSubExamList(String schoolId,String classesId,String studySubjectId){
        List<SubExam> list =svr.initSubExamList(schoolId,classesId,studySubjectId);
        return list;
    }

}
