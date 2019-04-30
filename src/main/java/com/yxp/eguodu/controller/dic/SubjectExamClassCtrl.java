package com.yxp.eguodu.controller.dic;

import com.yxp.eguodu.entity.SubjectExamClass;
import com.yxp.eguodu.service.dic.SubjectExamClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/dic/subjectexamclass", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class SubjectExamClassCtrl {

    @Autowired
    private SubjectExamClassService svr;

    @GetMapping(value="/subjectExamClassList")
    public List<SubjectExamClass> subjectExamClassList(){
        List<SubjectExamClass> list= svr.subjectExamClassList();
        return list;
    }



    @PostMapping(value="/insertSubjectExamClass")
    public Map<String,Object> insertSubjectExamClass(@RequestBody SubjectExamClass subjectExamClass){
        int d = svr.insertSubjectExamClass(subjectExamClass);
        if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    @PostMapping(value="/updateSubjectExamClass")
    public Map<String, Object> updateSubjectExamClass(@RequestBody SubjectExamClass subjectExamClass){
        int d = svr.updateSubjectExamClass(subjectExamClass);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    @GetMapping(value="/deleteSubjectExamClass")
    public Map<String, Object> deleteSubjectExamClass(String subjectExamClassId){

        int d =   svr.deleteSubjectExamClass(subjectExamClassId);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;

    }



}
