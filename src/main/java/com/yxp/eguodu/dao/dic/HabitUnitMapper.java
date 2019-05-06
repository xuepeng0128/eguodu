package com.yxp.eguodu.dao.dic;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface HabitUnitMapper {

    @Select("select unitName from dic_habitunit")
    public List<Map<String,Object>>  habitUnitList();


    @Insert("<script> insert into dic_habitunit(unitName) values('${unitName}')" +
            "</script>" +
            "")
    public int insertHabitUnit(Map<String,Object> paras);
}