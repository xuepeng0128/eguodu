package com.yxp.eguodu.service.dic;

import com.yxp.eguodu.entity.CircleClass;

import java.util.List;

public interface CircleClassService {

    public List<CircleClass> circleClassList();
    public int insertCircleClass(CircleClass circleClass);
    public int updateCircleClass(CircleClass circleClass);
    public int deleteCircleClass(String circleClassId);
}
