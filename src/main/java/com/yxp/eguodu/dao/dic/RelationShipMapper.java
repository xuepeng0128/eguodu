package com.yxp.eguodu.dao.dic;

import com.yxp.eguodu.entity.RelationShip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RelationShipMapper {

    @Select("<script>" +
            " select relationShipId,relationShipName from dic_relationship" +
            "</script>")
    public List<RelationShip> relationShipList();


}
