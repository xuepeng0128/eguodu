package com.yxp.eguodu.dao.basemsg;

import com.yxp.eguodu.common.queryparams.SchoolQueryParams;
import com.yxp.eguodu.entity.School;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface SchoolMapper {

    @Select("<script>" +
            "SELECT s.schoolId,s.schoolName , s.cityId,c.nationName as cityName , s.districtId ,d.nationName as districtName," +
            " s.longitude,s.latitude,s.address,s.schoolStyle,s.saleManId,e.employeeName as saleManName, s.regTime,s.train,s.tel,s.linkMan," +
            " ifnull(cla.classesNum,0) as classesNum , ifnull(cir.circleNum,0) as circleNum ,ifnull(sut.studentNum,0) as studentNum ," +
            "ifnull(tea.teacherNum,0) as teacherNum " +
            " from school s inner join dic_nation c on s.cityId=c.nationId " +
            "inner join dic_nation d on s.districtId=d.nationId " +
            "inner join employee e on s.saleManId =e.employeeId " +
            "left outer join " +
            "" +
            "(" +
            "    select schoolId,  ifnull(count(*),0) as classesNum from   classes " +
            "    group by schoolId " +
            ")cla on s.schoolId=cla.schoolId " +
            "" +
            "left outer join " +
            " (" +
            " select ca.schoolId, ifnull(count(*),0) as circleNum from classes ca left outer join " +
            " circle cr on ca.classesId=cr.classesId " +
            " GROUP BY ca.schoolId" +
            ")cir on s.schoolId=cir.schoolId " +
            "" +
            "left outer join " +
            "(" +
            "    select ca.schoolId,  ifnull(count(*),0) as studentNum from   classes ca  left outer join " +
            "     classesstudent sut on ca.classesId=sut.classesId" +
            "    group by ca.schoolId" +
            ")sut on s.schoolId=sut.schoolId " +
            "" +
            "left outer join " +
            "(" +
            "   select schoolId, ifnull(count(*),0) as teacherNum from teacher " +
            "   group by schoolId" +
            ")tea on s.schoolId=tea.schoolId" +
            " where 1=1 " +
            "<if test='schoolId != null and schoolId !=\"\" and schoolId !=\"0\"'>" +
            "  and s.schoolId like '%${schoolId}%' " +
            "</if>" +
            "<if test='schoolName != null and schoolName !=\"\" '>" +
            "  and s.schoolName like '%${schoolName}%' " +
            "</if>" +
            "<if test='cityId != null and cityId !=\"\" and cityId !=\"0\" '>" +
            "  and s.cityId= '%${cityId}%' " +
            "</if>" +
            "<if test='districtId != null and districtId !=\"\" and districtId !=\"0\"  '>" +
            "  and s.districtId= '${districtId}' " +
            "</if>" +
            "<if test='schoolStyle != null and schoolStyle !=\"\" and schoolStyle !=\"0\"  '>" +
            "  and s.schoolStyle= ${schoolStyle} " +
            "</if>" +
            "<if test='regTimeBegin != null and regTimeBegin !=\"\" '>" +
            "<![CDATA[  and s.regTime >= '${regTimeBegin}'  ]]>" +
            "</if>" +
            "<if test='regTimeEnd != null and regTimeEnd !=\"\" '>" +
            "<![CDATA[  and s.regTime <'${regTimeEnd}'  ]]>" +
            "</if>" +
            "<if test='train != null  and train !=0 '>" +
            "   and s.train=${train} " +
            "</if>" +
            "<if test='saleManId != null and saleManId !=\"\" and saleManId !=\"0\"  '>" +
            "   and s.saleManId='${saleManId}' " +
            "</if>" +
            " limit ${pageBegin} ,${pageSize}" +
            "</script>")
    public List<Map<String,Object>> schoolList(SchoolQueryParams params);

    @Select("<script>" +
            "SELECT count(*) as total " +
            " from school s inner join dic_nation c on s.cityId=c.nationId " +
            "inner join dic_nation d on s.districtId=d.nationId " +
            "inner join employee e on s.saleManId =e.employeeId " +
            "left outer join " +
            "" +
            "(" +
            "    select schoolId,  ifnull(count(*),0) as classesNum from   classes " +
            "    group by schoolId " +
            ")cla on s.schoolId=cla.schoolId " +
            "" +
            "left outer join " +
            " (" +
            " select ca.schoolId, ifnull(count(*),0) as circleNum from classes ca left outer join " +
            " circle cr on ca.classesId=cr.classesId " +
            " GROUP BY ca.schoolId" +
            ")cir on s.schoolId=cir.schoolId " +
            "" +
            "left outer join " +
            "(" +
            "    select ca.schoolId,  ifnull(count(*),0) as studentNum from   classes ca  left outer join " +
            "     classesstudent sut on ca.classesId=sut.classesId" +
            "    group by ca.schoolId" +
            ")sut on s.schoolId=sut.schoolId " +
            "" +
            "left outer join " +
            "(" +
            "   select schoolId, ifnull(count(*),0) as teacherNum from teacher " +
            "   group by schoolId" +
            ")tea on s.schoolId=tea.schoolId" +
            " where 1=1 " +
            "<if test='schoolId != null and schoolId !=\"\" and schoolId !=\"0\" '>" +
            "  and s.schoolId like '%${schoolId}%' " +
            "</if>" +
            "<if test='schoolName != null and schoolName !=\"\" '>" +
            "  and s.schoolName like '%${schoolName}%' " +
            "</if>" +
            "<if test='cityId != null and cityId !=\"\" and cityId !=\"0\"  '>" +
            "  and s.cityId= '%${cityId}%' " +
            "</if>" +
            "<if test='districtId != null and districtId !=\"\" and districtId !=\"0\"  '>" +
            "  and s.districtId= '${districtId}' " +
            "</if>" +

            "<if test='schoolStyle != null and schoolStyle !=\"\" and schoolStyle !=\"0\"  '>" +
            "  and s.schoolStyle= ${schoolStyle} " +
            "</if>" +
            "<if test='regTimeBegin != null  '>" +
            "<![CDATA[  and s.regTime >= '${regTimeBegin}'  ]]>" +
            "</if>" +
            "<if test='regTimeEnd != null  '>" +
            "<![CDATA[  and s.regTime <'${regTimeEnd}'  ]]>" +
            "</if>" +
            "<if test='train != null and train !=\"\" and train !=\"0\"  '>" +
            "   and s.train=${train} " +
            "</if>" +
            "<if test='saleManId != null and saleManId !=\"\" and saleManId !=\"0\"  '>" +
            "   and s.saleManId='${saleManId}' " +
            "</if>" +
            "</script>")
    public List<Map<String,Object>> schoolListTotal(SchoolQueryParams params);


    @Insert("<script>" +
            " insert into school(schoolId,schoolName,cityId,districtId,longitude,latitude,tel,linkman,address,schoolStyle,saleManId,regTime,train)" +
            " values (func_makeBusinessId('school', case when ${train}= false then  '0' else '1' end),#{schoolName},#{cityId}," +
            " #{districtId},#{longitude},#{latitude},#{tel},#{linkman},#{address},#{schoolStyle},#{saleManId},now(),#{train})" +
            "</script>")
    public int insertSchool(School school);

    @Update("<script>" +
            " update school set schoolName=#{schoolName}, cityId=#{cityId},districtId=#{districtId}," +
            " longitude=#{longitude},latitude=#{latitude},tel=#{tel},linkman=#{linkMan},address=#{address},schoolStyle=#{schoolStyle}," +
            " saleManId=#{saleManId},train=#{train} where schoolId=#{schoolId}" +
            "</script>")
    public int updateSchool(School school);

}
