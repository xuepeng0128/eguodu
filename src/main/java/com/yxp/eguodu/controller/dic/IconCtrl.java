package com.yxp.eguodu.controller.dic;

import com.yxp.eguodu.dao.dic.IconMapper;
import com.yxp.eguodu.entity.Icon;
import com.yxp.eguodu.service.dic.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/dic/icon", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class IconCtrl {
    @Autowired
    private IconService svr;

    @GetMapping(value="/iconList")
    public List<Icon> iconList(){
        return svr.iconList();
    }

    @PostMapping(value="/insertIcon")
    public Map<String,Object> insertIcon(@RequestBody Icon icon){
        svr.insertIcon(icon);
        return  new HashMap<String,Object>(){{
            put("result","ok");
        }};
    }

    @PostMapping(value="/deleteIcon")
    public Map<String,Object> deleteIcon(@RequestBody Icon icon){
        svr.deleteIcon(icon);
        return  new HashMap<String,Object>(){{
            put("result","ok");
        }};
    }
}
