package com.yxp.eguodu.dao.system;

import com.yxp.eguodu.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {

    @Select("select * from menu where kind = ${kind} and `show` =true ")
    public List<Menu> menuList(@Param("kind") String kind);
}
