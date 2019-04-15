package com.yxp.eguodu.dao.basemsg;

import com.yxp.eguodu.common.queryparams.ClassesQueryParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClassesMapper {

    @Select("select ")
   public List<Map<String,Object>> classesList(ClassesQueryParams params);

}
