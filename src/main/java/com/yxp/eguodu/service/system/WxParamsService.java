package com.yxp.eguodu.service.system;

import java.util.List;
import java.util.Map;

public interface WxParamsService {

    public List<Map<String, Object>> wxParamsList();

    public int insertWxParams(Map<String, Object> paras);
}
