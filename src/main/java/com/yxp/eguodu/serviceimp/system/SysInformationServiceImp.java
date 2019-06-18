package com.yxp.eguodu.serviceimp.system;

import com.yxp.eguodu.dao.system.SysInformationMapper;
import com.yxp.eguodu.entity.SysInformation;
import com.yxp.eguodu.service.system.SysInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysInformationServiceImp implements SysInformationService {
    @Autowired
    private SysInformationMapper mapper;
    @Override
    public List<SysInformation> sysInformationList(String pageBegin, String pageSize) {
        return mapper.sysInformationList(pageBegin,pageSize);
    }

    @Override
    public List<Map<String, Object>> sysInformationListTotal() {
        return mapper.sysInformationListTotal();
    }

    @Override
    public int insertInformation(SysInformation sysInformation) {
        return mapper.insertInformation(sysInformation);
    }
}
