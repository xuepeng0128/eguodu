package com.yxp.eguodu.serviceimp.basemsg;

import com.yxp.eguodu.common.queryparams.ClassesQueryParams;
import com.yxp.eguodu.service.basemsg.ClassesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClassesServiceImp implements ClassesService {
    @Override
    public List<Map<String, Object>> classesList(ClassesQueryParams params) {
        return null;
    }
}
