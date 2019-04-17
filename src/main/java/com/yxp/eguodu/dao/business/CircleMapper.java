package com.yxp.eguodu.dao.business;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CircleMapper {

    public List<Map<String ,Object>> circleList();




}
