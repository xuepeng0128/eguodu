package com.yxp.eguodu.dao.business;

import com.yxp.eguodu.entity.GuoduBill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GuoduCoinMapper {

    // 查询学生果度币流水账
    @Select("<script>" +
            " select studentId,billTime,guoduCoin,memo  from v_studentGuoduCoin where studentId ='${studentId}' " +
            " order by billTime desc " +
            " limit ${pageBegin},${pageSize} " +
            "</script>")
   public List<GuoduBill>  guoduBillList(@Param("studentId") String studentId, @Param("pageBegin") String pageBegin , @Param("pageSize") String pageSize);

}
