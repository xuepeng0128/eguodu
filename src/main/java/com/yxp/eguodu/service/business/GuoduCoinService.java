package com.yxp.eguodu.service.business;

import com.yxp.eguodu.entity.GuoduBill;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GuoduCoinService {
    // 查询学生果度币流水账
    public List<GuoduBill> guoduBillList( String studentId,  String pageBegin , String pageSize);

}
