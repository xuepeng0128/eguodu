package com.yxp.eguodu.service.system;

import com.yxp.eguodu.entity.SysInformation;

import java.util.List;

public interface SysInformationService {
    public List<SysInformation> sysInformationList(String pageBegin , String pageSize);

    public int insertInformation(SysInformation sysInformation);
}
