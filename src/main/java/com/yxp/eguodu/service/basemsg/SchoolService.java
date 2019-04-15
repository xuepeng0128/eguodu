package com.yxp.eguodu.service.basemsg;

import com.yxp.eguodu.common.queryparams.SchoolQueryParams;
import com.yxp.eguodu.entity.School;

import java.util.List;
import java.util.Map;

public interface SchoolService {

    public List<Map<String,Object>> schoolList(SchoolQueryParams schoolQueryParams);
    public List<Map<String,Object>> schoolListTotal(SchoolQueryParams schoolQueryParams);
    public int insertSchool(School school);
    public int updateSchool(School school);


}
