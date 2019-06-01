package com.yxp.eguodu.service.basemsg;

import com.yxp.eguodu.common.queryparams.SchoolQueryParams;
import com.yxp.eguodu.entity.School;

import java.util.List;
import java.util.Map;

public interface SchoolService {

    public List<Map<String,Object>> schoolList(SchoolQueryParams schoolQueryParams);
    public List<Map<String,Object>> schoolListTotal(SchoolQueryParams schoolQueryParams);
    // 根据省市区查找学校(正规学校)
    public List<Map<String,Object>> schoolListByAreaAndName( String districtId, String schoolName);
    public int insertSchool(School school);
    public int updateSchool(School school);


}
