package com.yxp.eguodu.dao.dic;

import com.yxp.eguodu.entity.Icon;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IconMapper {
    @Select("select iconUrl from dic_icon")
    public List<Icon> iconList();

    @Insert("<script>" +
            " insert into dic_icon(iconUrl) values(#{iconUrl})" +
            "</script>")
    public int insertIcon(Icon icon);


    @Delete("<script>" +
            " delete from dic_icon where iconUrl=#{iconUrl}" +
            "</script>")
    public int deleteIcon(Icon icon);


}
