package com.yxp.eguodu.dao.dic;

import com.yxp.eguodu.entity.HabitTemplate;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface HabitTemplateMapper {

    @Select({"<script> " +
            " SELECT  habitTemplateId,habitTemplateName,h.habitClassId,hc.habitClassName,h.subHabitClassId, " +
            "         hcs.habitClassName as subHabitClassName,icon,color,memo,picUrl,perTime,timeUnit, " +
            "         mode,timeModeNum,timeCompare , countModeNum,valueModeNum,unitName from dic_habittemplate h  " +
            " inner join dic_habitclass hc on h.habitClassId=hc.habitClassId " +
            " inner join dic_habitclass hcs on h.subHabitClassId=hcs.habitClassId " +
            " where 1=1 " +
            " limit #{pageBegin} ,#{pageSize} " +
            " </script>"})
    public List<HabitTemplate> habitTemplateList(Map<String,Object> paras);

    @Select("<script> SELECT  count(*) as total from dic_habittemplate h  " +
            "inner join dic_habitclass hc on h.habitClassId=hc.habitClassId " +
            "inner join dic_habitclass hcs on h.subHabitClassId=hcs.habitClassId " +
            " </script>")
    public List<Map<String,Object>> habitTemplateListTotal();



    @Insert("<script>" +
            "   insert into dic_habittemplate(habitTemplateId,habitTemplateName,habitClassId,subHabitClassId, " +
            "   icon,color,memo,picUrl,perTime,timeUnit, " +
            "   mode,timeModeNum,timeCompare,countModeNum,valueModeNum,unitName ) values ( func_makeDicId('habittemplate',''),#{habitTemplateName},#{habitClassId}," +
            "   #{subHabitClassId}, #{icon},#{color},#{memo},#{picUrl},#{perTime},#{timeUnit}, " +
            "   #{mode},#{timeModeNum},#{timeCompare},#{countModeNum},#{valueModeNum},#{unitName} )" +
            "</script>")
    public int insertHabitTemplate(HabitTemplate habitTemplate);

   @Update("<script>" +
           "   update dic_habittemplate set habitTemplateName = #{habitTemplateName},habitClassId= #{habitClassId},subHabitClassId= #{subHabitClassId}," +
           "         icon= #{icon},color= #{color},memo= #{memo},picUrl= #{picUrl},perTime= #{perTime},timeUnit= #{timeUnit}, " +
           "           mode= #{mode},timeModeNum= #{timeModeNum},timeCompare=#{timeCompare},countModeNum= #{countModeNum},valueModeNum= #{valueModeNum},unitName= #{unitName} where habitTemplateId=  #{habitTemplateId}" +
           "</script>")
   public int updateHabitTemplate(HabitTemplate habitTemplate);

   @Delete("<script>" +
           "  delete  from dic_habittemplate where habitTemplateId='${habitTemplateId}'" +
           "</script>")
   public int deleteHabitTemplate(Map<String,Object> paras);
}
