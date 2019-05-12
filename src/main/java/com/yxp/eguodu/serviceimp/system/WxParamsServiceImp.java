package com.yxp.eguodu.serviceimp.system;

import com.yxp.eguodu.dao.system.WxParamsMapper;
import com.yxp.eguodu.service.system.WxParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WxParamsServiceImp implements WxParamsService {
    @Autowired
    private WxParamsMapper mapper;
    @Override
    public List<Map<String, Object>> wxParamsList() {
        return mapper.wxParamsList();
    }

    @Override
    public int insertWxParams(Map<String, Object> paras) {
        mapper.deleteWxparams();
        mapper.insertWxParams(paras);
        return 1;
    }
}
