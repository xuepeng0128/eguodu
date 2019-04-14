package com.yxp.eguodu.serviceimp.dic;

import com.yxp.eguodu.dao.dic.CorpDutyMapper;
import com.yxp.eguodu.entity.CorpDuty;
import com.yxp.eguodu.service.dic.CorpDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorpDutyServiceImp implements CorpDutyService {
    @Autowired
    private CorpDutyMapper mapper;
    @Override
    public List<CorpDuty> corpDutyList() {
        return mapper.corpDutyList();
    }


    @Override
    public int insertCorpDuty(CorpDuty corpDuty) {
        return mapper.insertCorpDuty(corpDuty);
    }

    @Override
    public int updateCorpDuty(CorpDuty corpDuty) {

       return  mapper.updateCorpDuty(corpDuty);
    }

    @Override
    public int deleteCorpDuty(String corpDutyId) {
       return mapper.deleteCorpDuty(corpDutyId);
    }
}
