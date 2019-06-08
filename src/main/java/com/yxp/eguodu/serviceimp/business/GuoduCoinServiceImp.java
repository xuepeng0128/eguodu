package com.yxp.eguodu.serviceimp.business;

import com.yxp.eguodu.dao.business.GuoduCoinMapper;
import com.yxp.eguodu.entity.GuoduBill;
import com.yxp.eguodu.service.business.GuoduCoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuoduCoinServiceImp implements GuoduCoinService {
    @Autowired
    private GuoduCoinMapper mapper;
    @Override
    public List<GuoduBill> guoduBillList(String studentId, String pageBegin, String pageSize) {
        return mapper.guoduBillList(studentId,pageBegin,pageSize);
    }
}
