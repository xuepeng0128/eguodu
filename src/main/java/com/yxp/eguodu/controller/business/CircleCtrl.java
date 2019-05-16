package com.yxp.eguodu.controller.business;

import com.yxp.eguodu.common.queryparams.CircleQueryParams;
import com.yxp.eguodu.entity.Circle;
import com.yxp.eguodu.service.business.CircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/business/circle", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class CircleCtrl {
  @Autowired
    private CircleService svr;
     
  @GetMapping(value="/circleList")
    public List<Map<String ,Object>> circleList(   String circleTitle, String schoolId, String schoolName, String classesId, String grade,
                                                    String classes,String classesName,String buildTeacherId, String buildTeacherName,
                                                    String buildTimeBegin , String  buildTimeEnd , String  closeMan, String  closeTime , 
                                                    String  closeReason ,  String pageSize, String pageNo,String pageBegin){
      CircleQueryParams circleQueryParams = new CircleQueryParams( circleTitle,  schoolId,  schoolName,  classesId,  grade,
               classes, classesName, buildTeacherId,  buildTeacherName,
               buildTimeBegin ,   buildTimeEnd ,   closeMan,   closeTime ,
                closeReason ,   pageSize,  pageNo, pageBegin);
      return svr.circleList(circleQueryParams);
    } 
   @GetMapping(value="/circleListTotal")
    public Map<String,Object> circleListTotal(String circleTitle, String schoolId, String schoolName, String classesId, String grade,
                                                    String classes,String classesName,String buildTeacherId, String buildTeacherName,
                                                    String buildTimeBegin , String  buildTimeEnd , String  closeMan, String  closeTime ,
                                                    String  closeReason ,  String pageSize, String pageNo,String pageBegin){
       CircleQueryParams circleQueryParams = new CircleQueryParams( circleTitle,  schoolId,  schoolName,  classesId,  grade,
               classes, classesName, buildTeacherId,  buildTeacherName,
               buildTimeBegin ,   buildTimeEnd ,   closeMan,   closeTime ,
               closeReason ,   pageSize,  pageNo, pageBegin);




       Map<String,Object> re= new HashMap<String,Object>();
       re.put("total", Integer.parseInt( svr.circleListTotal(circleQueryParams).get(0).get("total").toString()));
       return re;
   }

   @PostMapping(value="/insertCircle")
    public Map<String,Object> insertCircle( @RequestBody Circle circle){
        int d =svr.insertCircle(circle);
        if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }
    @PostMapping(value="/updateCircle")
    public Map<String,Object> updateCircle(@RequestBody Circle circle){
        int d =svr.updateCircle(circle);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }
    @GetMapping(value="/deleteCircle")
    public Map<String,Object> deleteCircle(String circleId){
        int d =svr.deleteCircle(new HashMap<String,Object>(){{
            put("circleId",circleId);
        }});
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }
    @GetMapping(value="/closeCircle")
    public Map<String,Object> closeCircle(String closeMan,String closeReason){
        int d =svr.deleteCircle(new HashMap<String,Object>(){{
            put("closeMan",closeMan);
            put("closeReason",closeReason);
        }});
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }






}
