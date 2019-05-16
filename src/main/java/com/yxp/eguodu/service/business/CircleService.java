package com.yxp.eguodu.service.business;

import com.yxp.eguodu.common.queryparams.CircleQueryParams;
import com.yxp.eguodu.entity.Circle;


import java.util.List;
import java.util.Map;

public interface CircleService {

    public List<Map<String ,Object>> circleList(CircleQueryParams circleQueryParams);

    public List<Map<String,Object>> circleListTotal(CircleQueryParams circleQueryParams);

    public int insertCircle(Circle circle);

    public int updateCircle(Circle circle);

    public int deleteCircle(Map<String,Object> paras);

    public int closeCircle(Map<String,Object> paras);
}
