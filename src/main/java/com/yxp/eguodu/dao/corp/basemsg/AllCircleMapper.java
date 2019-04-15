package com.yxp.eguodu.dao.corp.basemsg;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface AllCircleMapper {



    @Select("")
    public List<Map<String,Object>> allCircleList(Map<String,Object> paras);


}
