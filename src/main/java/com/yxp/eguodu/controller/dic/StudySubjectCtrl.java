package com.yxp.eguodu.controller.dic;

import com.yxp.eguodu.entity.StudySubject;
import com.yxp.eguodu.service.dic.StudySubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/dic/studysubject", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class StudySubjectCtrl {

    @Autowired
    private StudySubjectService svr;

    @GetMapping(value="/studySubjectList")
    public List<StudySubject> studySubjectList(){
        List<StudySubject> list= svr.studySubjectList();
        return list;
    }



    @PostMapping(value="/insertStudySubject")
    public Map<String,Object> insertStudySubject(@RequestBody StudySubject studySubject){
        int d = svr.insertStudySubject(studySubject);
        if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    @PostMapping(value="/updateStudySubject")
    public Map<String, Object> updateStudySubject(@RequestBody StudySubject studySubject){
        int d = svr.updateStudySubject(studySubject);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    @GetMapping(value="/deleteStudySubject")
    public Map<String, Object> deleteStudySubject(String studySubjectId){

        int d =   svr.deleteStudySubject(studySubjectId);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;

    }




}
