package com.yxp.eguodu.dao.system;

import com.yxp.eguodu.entity.SysInformation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysInformationMapper {

    @Select("<script>" +
            " select id,information,sendTime  from sysinformation order by id desc limit ${pageBegin},${pageSize} " +
            "</script>")
    public List<SysInformation> sysInformationList(@Param("pageBegin") String pageBegin , @Param("pageSize") String pageSize);


    @Select("<script>" +
            " select count(1) as total  from sysinformation  " +
            "</script>")
    public List<Map<String,Object>> sysInformationListTotal();



    @Insert("<script>" +
            " insert into sysinformation(information,sendTime) values( #{information},now()) " +
            "</script>")
    public int insertInformation(SysInformation sysInformation);
}
