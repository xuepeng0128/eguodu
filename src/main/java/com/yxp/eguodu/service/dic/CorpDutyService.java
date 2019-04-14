package com.yxp.eguodu.service.dic;


import com.yxp.eguodu.entity.CorpDuty;

import java.util.List;

public interface CorpDutyService {
    public List<CorpDuty> corpDutyList();
    public int insertCorpDuty(CorpDuty corpDuty);
    public int updateCorpDuty(CorpDuty corpDuty);
    public int deleteCorpDuty(String corpDutyId);

}
