package com.yxp.eguodu.dao.system;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface WxParamsMapper {

    @Select("select param from wxparams")
    public List<Map<String,Object>> wxParamsList();

    @Insert("<script> insert into wxparams(param) values(#{param}) </script>")
    public int insertWxParams(Map<String,Object> paras);

    @Delete("<script> delete from wxparams </script>")
    public int deleteWxparams();


}
