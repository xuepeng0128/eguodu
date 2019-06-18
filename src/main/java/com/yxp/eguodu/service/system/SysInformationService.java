package com.yxp.eguodu.service.system;

import com.yxp.eguodu.entity.SysInformation;

import java.util.List;
import java.util.Map;

public interface SysInformationService {
    public List<SysInformation> sysInformationList(String pageBegin , String pageSize);

    public List<Map<String,Object>> sysInformationListTotal();

    public int insertInformation(SysInformation sysInformation);
}
