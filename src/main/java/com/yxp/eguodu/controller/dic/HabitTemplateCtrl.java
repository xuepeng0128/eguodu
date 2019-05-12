package com.yxp.eguodu.controller.dic;

import com.yxp.eguodu.entity.HabitTemplate;
import com.yxp.eguodu.service.dic.HabitTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/dic/habittemplate",
        method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class HabitTemplateCtrl {
    @Autowired
    private HabitTemplateService svr;


    @GetMapping(value="/habitTemplateList")
    public List<HabitTemplate> HabitTemplateList(String pageBegin,String pageSize){
        List<HabitTemplate> list= svr.habitTemplateList(new HashMap<String,Object>(){{

            put("pageBegin",Integer.parseInt(pageBegin));
            put("pageSize",Integer.parseInt(pageSize));
        }});
        return list;
    }
    @GetMapping(value="/habitTemplateListTotal")
    public Map<String,Object> habitTemplateListTotal(){
        Map<String,Object> re= new HashMap<String,Object>();
        re.put("total", Integer.parseInt( svr.habitTemplateListTotal().get(0).get("total").toString()));
        return re;
    }

    @PostMapping(value="/insertHabitTemplate")
    public Map<String,Object> insertHabitTemplate(@RequestBody HabitTemplate habitTemplate){
        int d = svr.insertHabitTemplate(habitTemplate);
        if (d>0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    @PostMapping(value="/updatehabitTemplate")
    public Map<String, Object> updatehabitTemplate(@RequestBody HabitTemplate habitTemplate){
        int d = svr.updateHabitTemplate(habitTemplate);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }

    @GetMapping(value="/deleteHabitTemplate")
    public Map<String, Object> deleteHabitTemplate(String habitTemplateId){
        int d =   svr.deleteHabitTemplate(new HashMap<String,Object>(){{
            put("habitTemplateId",habitTemplateId);
        }});
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;

    }

}
