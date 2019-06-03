package com.yxp.eguodu.wxcontroller.business;

import com.yxp.eguodu.entity.HabitTemplate;
import com.yxp.eguodu.service.dic.HabitTemplateService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(value="微信习惯",tags={"微信小程序习惯相关操作webapi接口"})
@CrossOrigin
@RestController
@RequestMapping(value = "/api/wxhabit",  produces = "application/json;charset=UTF-8")
public class WxHabitCtrl {
    @Autowired
    private HabitTemplateService habitTemplateService;



    public Map  habitTemplateList(String pageNo,String pageSize){
        String pageBegin= String.valueOf ((Integer.parseInt(pageNo) -1)* Integer.parseInt(pageSize));
        List<HabitTemplate> list =habitTemplateService.habitTemplateList( new HashMap<String,Object>(){{
            put("pageSize",pageSize);
            put("pageBegin",pageBegin);
        }});
        Map map = new HashMap();
        map.put("data", list );
        map.put("resultMsg", "ok");
        return map;
    }
}
