package com.yxp.eguodu.dao.dic;

import com.yxp.eguodu.entity.Nation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NationMapper {

    @Select("select nationId,nationName from dic_nation")
    public List<Nation> nationList();

}
