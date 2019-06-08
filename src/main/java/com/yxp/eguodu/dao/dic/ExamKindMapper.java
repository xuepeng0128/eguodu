package com.yxp.eguodu.dao.dic;

import com.yxp.eguodu.entity.ExamKind;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExamKindMapper {
    @Select("<script>" +
            "  select examKindId,examKindName from dic_examkind" +
            "</script>")
    public List<ExamKind> examKindList();
}
