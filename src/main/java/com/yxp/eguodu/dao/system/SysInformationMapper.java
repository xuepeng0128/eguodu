package com.yxp.eguodu.dao.system;

import com.yxp.eguodu.entity.SysInformation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysInformationMapper {

    @Select("<script>" +
            " select id,information,sendTime  from sysinformation order by id desc limit ${pageBegin},${pageSize} " +
            "</script>")
    public List<SysInformation> sysInformationList(@Param("pageBegin") String pageBegin , @Param("pageSize") String pageSize);

    @Insert("<script>" +
            " insert into sysinformation(information,sendTime) values( #{information},now()) " +
            "</script>")
    public int insertInformation(SysInformation sysInformation);
}
