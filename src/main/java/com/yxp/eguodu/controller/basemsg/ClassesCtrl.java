package com.yxp.eguodu.controller.basemsg;

import com.yxp.eguodu.common.queryparams.ClassesQueryParams;
import com.yxp.eguodu.entity.Classes;
import com.yxp.eguodu.service.basemsg.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/basemsg/classes", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class ClassesCtrl {

    @Autowired
    private ClassesService svr;

    @GetMapping(value="/classesList")
    public List<Map<String,Object>> classesList (String grade, String classes , String schoolId, String schoolName, String teacherPaperId, String studentName, String pageSize, String pageNo, String pageBegin)
    {
        ClassesQueryParams queryParams = new ClassesQueryParams(  grade, classes ,  schoolId,  schoolName,  teacherPaperId,  studentName,  pageSize,  pageNo,  pageBegin);
        return svr.classesList(queryParams);
    }

    

}
