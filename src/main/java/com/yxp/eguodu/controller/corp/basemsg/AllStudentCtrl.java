package com.yxp.eguodu.controller.corp.basemsg;

import com.yxp.stuhabit.entity.Student;
import com.yxp.stuhabit.service.basemsg.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/corp/basemsg/student", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class AllStudentCtrl {
   @Autowired
    private StudentService svr;

    @GetMapping(value="/studentList")
    public List<Student> studentList(String paperId, String studentName,String sex, String ageBegin , String ageEnd, String pageSize, String pageNo,String getTotal){
        return svr.studentList(paperId, studentName, sex,ageBegin ,  ageEnd,  pageSize,  pageNo,getTotal);
    }



}
