package com.yxp.eguodu.controller.business;


import com.yxp.eguodu.common.queryparams.TeacherArticleQueryParams;
import com.yxp.eguodu.entity.TeacherArticle;
import com.yxp.eguodu.service.business.TeacherArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/business/teacherArticle", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class TeacherArticleCtrl {
    @Autowired
    private TeacherArticleService svr;

    @GetMapping(value="/teacherArticleList")
    public List<Map<String,Object>>  teacherArticleList(String teacherId,String teacherName,String schoolId,
                                                        String schoolName,String pageNo,String pageBegin,String pageSize){
        List<Map<String,Object>> list = svr.teacherArticleList( new TeacherArticleQueryParams (
          teacherId,teacherName,schoolId,schoolName,pageNo,pageBegin,pageSize
        ));
        return list;
    }

    @GetMapping(value="/teacherArticleListTotal")
    public Map<String,Object>  teacherArticleListTotal(String teacherId,String teacherName,String schoolId,
                                                        String schoolName,String pageNo,String pageBegin,String pageSize){
        List<Map<String,Object>> list = svr.teacherArticleListTotal( new TeacherArticleQueryParams (
                teacherId,teacherName,schoolId,schoolName,pageNo,pageSize,pageBegin
        ));
        Map<String,Object> re= new HashMap<String,Object>();
        re.put("total",Integer.parseInt( list.get(0).get("total").toString()));
        return re;
    }


    @PostMapping(value="/insertArticle")
    public Map<String,Object> insertArticle(@RequestBody TeacherArticle teacherArticle){
        int d = svr.insertArticle(teacherArticle);
            if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }


    @PostMapping(value="/updateArticle")
    public Map<String,Object> updateArticle(@RequestBody TeacherArticle teacherArticle){
        int d = svr.updateArticle(teacherArticle);
        if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }


    @PostMapping(value="/publishTeacherArticle")
   public Map<String,Object>   publishTeacherArticle( @RequestBody Map<String,Object> paras)
   {
       List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
       List<String> hlist = (List<String>) paras.get("teacherHabitIds");

       for(String habitid : hlist){
           list.add(new HashMap<String,Object>(){{
               put("circleHabitId" , habitid);
               put("articleId",paras.get("articleId").toString() );
           }});
       }
       paras.put("habitlist",list);
       int d = svr.publishArticle(paras);
       if (d>=0)
           return new HashMap<String,Object>(){{put("result","ok") ;}} ;
       else
           return new HashMap<String,Object>(){{put("result","fail") ;}} ;
   }

   @GetMapping(value="/deleteTeacherArticle")
   public Map<String,Object>   deleteTeacherArticle( String articleId){
       int d = svr.publishArticle(new HashMap<String,Object>(){{
           put("articleId",articleId);
       }});
       if (d>=0)
           return new HashMap<String,Object>(){{put("result","ok") ;}} ;
       else
           return new HashMap<String,Object>(){{put("result","fail") ;}} ;
   }

    @GetMapping(value="/publishToHabit")
    public  Map<String,Object> publishToHabit(String habitId, String articleId){

        svr.publishToHabit(habitId,articleId);

        return new HashMap<String,Object>(){{put("result","ok") ;}} ;
    }

}
