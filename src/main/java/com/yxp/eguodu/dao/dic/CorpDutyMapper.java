package com.yxp.eguodu.dao.dic;

import com.yxp.eguodu.entity.CorpDuty;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CorpDutyMapper {

    @Select("select corpDutyId ,corpDutyName,master from dic_corpduty")
    public List<CorpDuty> corpDutyList();
    @Insert("<script>" +
            " " +
            "</script>")
    public int insertCorpDuty(CorpDuty corpDuty);
    public int updateCorpDuty(CorpDuty corpDuty);
    public int deleteCorpDuty(String corpDutyId);


}
