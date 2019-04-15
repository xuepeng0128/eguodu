package com.yxp.eguodu.dao.dic;

import com.yxp.eguodu.entity.CorpDuty;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 公司职务
 */
@Mapper
public interface CorpDutyMapper {

    @Select("select corpDutyId ,corpDutyName,master from dic_corpduty")
    public List<CorpDuty> corpDutyList();
    @Insert("<script>" +
            "  insert into dic_corpduty(corpDutyId ,corpDutyName,master) " +
            "  values (func_makeDicId('corpduty'),'${corpDutyName}',${master})" +
            "</script>")
    public int insertCorpDuty(CorpDuty corpDuty);

    @Update("update dic_corpduty set corpDutyName='${corpDutyName}',master=${master} where corpDutyId='${corpDutyId}'")
    public int updateCorpDuty(CorpDuty corpDuty);
    @Delete("<script>" +
            " delete from dic_corpduty where corpDutyId='${corpDutyId}'" +
            "</script>")
    public int deleteCorpDuty(String corpDutyId);


}
