package com.yxp.eguodu.controller.basemsg;

import com.yxp.eguodu.common.queryparams.SchoolQueryParams;
import com.yxp.eguodu.entity.School;
import com.yxp.eguodu.service.basemsg.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/basemsg/school", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class SchoolCtrl {
     @Autowired
    private SchoolService svr;

     @GetMapping(value="/schoolList")
     public List<Map<String,Object>> schoolList(  String schoolId, String schoolName, String cityId,String districtId,
                                                  String schoolStyle,@DateTimeFormat(pattern="yyyy-MM-dd") Date regTimeBegin,
                                                  @DateTimeFormat(pattern="yyyy-MM-dd") Date regTimeEnd, boolean train, String saleManId,
                                                  String pageSize,String pageNo,String pageBegin) {
         SchoolQueryParams params= new SchoolQueryParams(schoolId,  schoolName, cityId, districtId, schoolStyle,
                                                       regTimeBegin, regTimeEnd, train, saleManId, pageSize,pageNo,pageBegin);

         List<Map<String,Object>> list = svr.schoolList(params);
         return list;
     }

    @GetMapping(value="/schoolListTotal")
    public Map<String,Object> schoolListTotal(String schoolId, String schoolName, String cityId, String districtId,
                               String schoolStyle, @DateTimeFormat(pattern="yyyy-MM-dd") Date regTimeBegin,
                               @DateTimeFormat(pattern="yyyy-MM-dd") Date regTimeEnd, boolean train, String saleManId, String pageSize, String pageNo) {
        SchoolQueryParams params= new SchoolQueryParams(schoolId,  schoolName, cityId, districtId, schoolStyle,
                regTimeBegin, regTimeEnd, train, saleManId, pageSize,pageNo,"");

        Map<String,Object> re= new HashMap<String,Object>();
         re.put("total", Integer.parseInt( svr.schoolListTotal(params).get(0).get("total").toString()));
         return re;
    }






     @PostMapping(value = "/insertSchool")
     public Map<String,Object> insertSchool(@RequestBody School school){
         int d = svr.insertSchool(school);
         if (d>0)
             return new HashMap<String,Object>(){{put("result","ok") ;}} ;
         else
             return new HashMap<String,Object>(){{put("result","fail") ;}} ;

     }

    @PostMapping(value = "/updateSchool")
    public Map<String,Object> updateSchool(@RequestBody School school){
        int d = svr.updateSchool(school);
        if (d>=0)
            return new HashMap<String,Object>(){{put("result","ok") ;}} ;
        else
            return new HashMap<String,Object>(){{put("result","fail") ;}} ;
    }


}
