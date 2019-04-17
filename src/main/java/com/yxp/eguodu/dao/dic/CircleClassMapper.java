package com.yxp.eguodu.dao.dic;

import com.yxp.eguodu.entity.CircleClass;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CircleClassMapper {


    @Select("select circleClassId ,circleClassName,pareClassId from dic_circleclass")
    public List<CircleClass> circleClassList();
    @Insert("<script>" +
            "  insert into dic_circleclass(circleClassId ,circleClassName,pareClassId) " +
            "  values (func_makeDicId('corpduty'),'${circleClassName}','${pareClassId}')" +
            "</script>")
    public int insertCircleClass(CircleClass circleClass);

    @Update("update dic_circleclass set circleClassName='${circleClassName}',pareClassId='${pareClassId}' where circleClassId='${circleClassId}'")
    public int updateCircleClass(CircleClass circleClass);
    @Delete("<script>" +
            " delete from dic_circleclass where circleClassId='${circleClassId}'" +
            "</script>")
    public int deleteCircleClass(String circleClassId);





}
