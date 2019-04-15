package com.yxp.eguodu.controller.dic;

import com.yxp.eguodu.entity.StudySubject;
import com.yxp.eguodu.service.dic.StudySubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String insertStudySubject(@RequestBody StudySubject studySubject){
        int d = svr.insertStudySubject(studySubject);
        if (d>0)
            return "ok";
        else
            return "fail";
    }

    @PostMapping(value="/updateStudySubject")
    public String updateStudySubject(@RequestBody StudySubject studySubject){
        int d = svr.updateStudySubject(studySubject);
        if (d>=0)
            return "ok";
        else
            return "fail";
    }

    @GetMapping(value="/deleteStudySubject")
    public String deleteStudySubject(String studySubjectId){

        int d =   svr.deleteStudySubject(studySubjectId);
        if (d>=0)
            return "ok";
        else
            return "fail";

    }




}
