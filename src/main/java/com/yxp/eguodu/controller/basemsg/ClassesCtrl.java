package com.yxp.eguodu.controller.basemsg;

import com.yxp.eguodu.common.queryparams.ClassesQueryParams;
import com.yxp.eguodu.entity.Classes;
import com.yxp.eguodu.service.basemsg.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/basemsg/classes", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class ClassesCtrl {

    @Autowired
    private ClassesService svr;

    @GetMapping(value="/classesList")
    public List<Map<String,Object>> classesList (String classesId,String grade, String classes , String schoolId, String schoolName, String pageSize, String pageNo, String pageBegin)
    {
        ClassesQueryParams queryParams = new ClassesQueryParams( classesId, grade, classes ,  schoolId,  schoolName,  pageSize,  pageNo,  pageBegin);
        return svr.classesList(queryParams);
    }

    @GetMapping(value="/classesListTotal")
    public Map<String,Object> classesListTotal (String classesId, String grade, String classes , String schoolId, String schoolName, String pageSize, String pageNo, String pageBegin)
    {
        ClassesQueryParams queryParams = new ClassesQueryParams(classesId,  grade, classes ,  schoolId,  schoolName,  pageSize,  pageNo,  pageBegin);
        return
                new HashMap<String,Object>(){{
                    put("total", svr.classesListTotal(queryParams));

                }};
    }

    @PostMapping(value="/insertClasses")
    public Map<String,Object> insertClasses(@RequestBody Classes classes){
       return null;
    }



}
